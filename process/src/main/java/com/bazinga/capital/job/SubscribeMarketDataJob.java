package com.bazinga.capital.job;

import com.bazinga.capital.api.QuoteApiService;
import com.zts.xtp.common.enums.ExchangeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Component
@Slf4j
public class SubscribeMarketDataJob {

    @Autowired
    private QuoteApiService quoteApiService;

    public void execute() {
        log.info("SubscribeMarketDataJob start...");
        try {
            String[] tickerArray = new String[]{"002868"};
            quoteApiService.subscribeMarketData(tickerArray, 1, ExchangeType.SZ.getType());

        } catch (Exception e) {
            log.error("SubscribeMarketDataJob error", e);
        }
        log.info("SubscribeMarketDataJob end ");
    }
}
