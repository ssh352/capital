package com.bazinga.capital.component;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.api.QuoteApiService;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.base.Sort;
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
public class ApiComponent {

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
            log.warn("未查询到10s 后的行情数据");
        } else {
            DepthMarketData depthMarketData = list.get(0);
            String bidQty = depthMarketData.getBidQty();
            Long[] bidQtyArr = JSONObject.parseObject(bidQty, Long[].class);
            if (bidQty != null && bidQtyArr.length > 0) {
                CirculateInfoQuery circulateQuery = new CirculateInfoQuery();
                circulateQuery.setTicker(ticker);
                List<CirculateInfo> circulateInfos = circulateInfoService.listByCondition(circulateQuery);
                if (!CollectionUtils.isEmpty(circulateInfos)) {
                    CirculateInfo circulateInfo = circulateInfos.get(0);
                    if (circulateInfo.getCirculateType() == 0) {
                        if (bidQtyArr[0] < circulateInfo.getCirculateZ() * 0.05) {
                            log.info("触发小于 流通 z 股数 撤单 ticker = {},orderXtpId = {}", ticker, orderXtpId);
                            tradeApiService.cancelOrder(orderXtpId);
                        }
                    } else if (circulateInfo.getCirculateType() == 1) {
                        if (bidQtyArr[0] < circulateInfo.getCirculateZ() * 0.03) {
                            log.info("触发小于 流通 z 股数 撤单 ticker = {},orderXtpId = {}", ticker, orderXtpId);
                            tradeApiService.cancelOrder(orderXtpId);
                        }
                    } else if (circulateInfo.getCirculateType() == 2) {
                        if (bidQtyArr[0] < circulateInfo.getCirculateZ() * 0.02) {
                            log.info("触发小于 流通 z 股数 撤单 ticker = {},orderXtpId = {}", ticker, orderXtpId);
                            tradeApiService.cancelOrder(orderXtpId);
                        }
                    } else {
                        log.warn("流通 z 信息类型不存在");
                    }
                }
            }

        }
    }


}
