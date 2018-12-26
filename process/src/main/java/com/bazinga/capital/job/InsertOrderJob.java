package com.bazinga.capital.job;

import com.bazinga.capital.api.TradeApiService;
import com.zts.xtp.common.enums.BusinessType;
import com.zts.xtp.common.enums.MarketType;
import com.zts.xtp.common.enums.PriceType;
import com.zts.xtp.common.enums.SideType;
import com.zts.xtp.trade.api.TradeApi;
import com.zts.xtp.trade.model.request.OrderInsertRequest;
import com.zts.xtp.trade.spi.TradeSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2018/12/26
 */
@Component
@Slf4j
public class InsertOrderJob {

    @Autowired
    private TradeApiService tradeApiService;

    public void execute() {
        log.info("testInsertOrder");
        OrderInsertRequest req = OrderInsertRequest.builder()
                .orderXtpId("0").orderClientId(13).ticker("300760").marketType(MarketType.XTP_MKT_SZ_A)
                .price(116.59).stopPrice(0).quantity(1000).priceType(PriceType.XTP_PRICE_LIMIT)
                .sideType(SideType.XTP_SIDE_BUY).businessType(BusinessType.XTP_BUSINESS_TYPE_CASH).build();

        String orderXtpId = null;
        try {
            orderXtpId = tradeApiService.insertOrder(req);
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("orderXtpId={}", orderXtpId);
    }
}
