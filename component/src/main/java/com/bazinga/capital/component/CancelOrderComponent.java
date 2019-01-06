package com.bazinga.capital.component;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.api.QuoteApiService;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.base.Sort;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.constant.CommonConstant;
import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.model.CirculateInfo;
import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.query.CirculateInfoQuery;
import com.bazinga.capital.query.DepthMarketDataQuery;
import com.bazinga.capital.service.CirculateInfoService;
import com.bazinga.capital.service.DepthMarketDataService;
import com.bazinga.capital.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author yunshan
 * @date 2019/1/5
 */
@Component
@Slf4j
public class CancelOrderComponent {

    @Autowired
    private TradeApiService tradeApiService;

    @Autowired
    private QuoteApiService quoteApiService;

    @Autowired
    private DepthMarketDataService depthMarketDataService;

    @Autowired
    private CirculateInfoService circulateInfoService;

    public void checkCirculationAndCancelOrder(String ticker, String orderXtpId) {
        DepthMarketDataQuery query = new DepthMarketDataQuery();
        Date currentDate = new Date();
        Date startDate = DateUtil.addSeconds(currentDate, 10);
        query.setDataTimeTo(currentDate);
        query.setDataTimeFrom(startDate);
        query.setTicker(ticker);
        query.addOrderBy("date_time", Sort.SortType.DESC);
        List<DepthMarketData> list = depthMarketDataService.listByCondition(query);
        if (CollectionUtils.isEmpty(list)) {
            log.warn("未查询到10s 后的行情数据 ticker= {},orderXtpId ={}", ticker, orderXtpId);
        } else {
            DepthMarketData depthMarketData = list.get(0);
            String bidQty = depthMarketData.getBidQty();
            Long[] bidQtyArr = JSONObject.parseObject(bidQty, Long[].class);
            if (bidQty != null && bidQtyArr.length > 0) {
                TickerConfigDTO tickerConfigDTO = CacheDataCenter.TICKER_CONFIG_MAP.get(ticker);
                if (tickerConfigDTO != null) {
                    if (bidQtyArr[0] < tickerConfigDTO.getCirculateZ() * tickerConfigDTO.getPercent() / CommonConstant.ONE_HUNDRED) {
                        log.info("触发小于 流通 z 股数 撤单 ticker = {},orderXtpId = {}", ticker, orderXtpId);
                        tradeApiService.cancelOrder(orderXtpId);
                    }
                }
            }
        }
    }


}
