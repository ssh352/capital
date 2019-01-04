package com.bazinga.capital.listener;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.event.MarketData2InsertOrderEvent;
import com.zts.xtp.common.enums.BusinessType;
import com.zts.xtp.common.enums.MarketType;
import com.zts.xtp.common.enums.SideType;
import com.zts.xtp.trade.model.request.OrderInsertRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

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

    @Override
    public void onApplicationEvent(MarketData2InsertOrderEvent event) {
        log.info("监听到委托下单事件 ticker = {},price = {}", event.getTicker(), event.getOrderPrice());
        OrderInsertRequest orderInsertRequest = OrderInsertRequest.builder()
                .businessType(BusinessType.XTP_BUSINESS_TYPE_CASH)
                .marketType(MarketType.XTP_MKT_SZ_A)
                .price(event.getOrderPrice().doubleValue())
                .ticker(event.getTicker())
                .sideType(SideType.XTP_SIDE_BUY)
                .quantity(1000).build();
        try {
            String xtpOrderId = tradeApiService.insertOrder(orderInsertRequest);
            log.info("调用 api 委托下单完成");
        } catch (Exception e) {
            log.error("委托下单异常 参数 = " + JSONObject.toJSONString(event), e);
        }
    }
}
