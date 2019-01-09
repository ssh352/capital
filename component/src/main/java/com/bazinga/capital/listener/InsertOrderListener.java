package com.bazinga.capital.listener;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.enums.OperateTypeEnum;
import com.bazinga.capital.event.MarketData2InsertOrderEvent;
import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.service.DisableInsertTicketService;
import com.bazinga.capital.util.DateUtil;
import com.zts.xtp.common.enums.BusinessType;
import com.zts.xtp.common.enums.MarketType;
import com.zts.xtp.common.enums.PriceType;
import com.zts.xtp.common.enums.SideType;
import com.zts.xtp.trade.model.request.OrderInsertRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 下单监听器
 *
 * @author yunshan
 * @date 2019/1/4
 */
@Component
@Slf4j
public class InsertOrderListener implements ApplicationListener<MarketData2InsertOrderEvent> {

    @Autowired
    private TradeApiService tradeApiService;

    @Autowired
    private DisableInsertTicketService disableInsertTicketService;

    @Override
    public void onApplicationEvent(MarketData2InsertOrderEvent event) {
        log.info("监听到委托下单事件 ticker = {},price = {}", event.getTicker(), event.getOrderPrice());
        if (CacheDataCenter.DISABLE_INSERT_ORDER_SET.contains(event.getTicker())) {
            log.info("当天 已经下单 不满足下单条件");
        } else {
            try {
                OrderInsertRequest orderInsertRequest = OrderInsertRequest.builder()
                        .businessType(BusinessType.XTP_BUSINESS_TYPE_CASH).orderXtpId("0")
                        .orderClientId(13)
                        .stopPrice(0)
                        .priceType(PriceType.XTP_PRICE_LIMIT)
                        .marketType(MarketType.XTP_MKT_SZ_A)
                        .price(event.getOrderPrice().doubleValue())
                        .ticker(event.getTicker())
                        .sideType(SideType.XTP_SIDE_BUY)
                        .quantity(100).build();
                tradeApiService.insertOrder(orderInsertRequest);
                CacheDataCenter.DISABLE_INSERT_ORDER_SET.add(event.getTicker());
                DisableInsertTicket disableInsertTicket = buildDisableInsertTicket(event.getTicker());
                disableInsertTicketService.save(disableInsertTicket);
                CacheDataCenter.TICKER_PERSIST_SET.add(event.getTicker());
                log.info("调用 api 委托下单完成");
            } catch (Exception e) {
                log.error("委托下单异常 参数 = " + JSONObject.toJSONString(event), e);
            }
        }
    }

    private DisableInsertTicket buildDisableInsertTicket(String ticker) {
        DisableInsertTicket disableInsertTicket = new DisableInsertTicket();
        disableInsertTicket.setOperateType(OperateTypeEnum.SYSTEM_AUTO.getCode());
        disableInsertTicket.setTicker(ticker);
        TickerConfigDTO tickerConfigDTO = CacheDataCenter.TICKER_CONFIG_MAP.get(ticker);
        if (tickerConfigDTO != null) {
            disableInsertTicket.setTickerName(tickerConfigDTO.getTickerName());
        }
        disableInsertTicket.setDay(DateUtil.format(new Date(), DateUtil.yyyy_MM_dd));
        return disableInsertTicket;
    }
}
