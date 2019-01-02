package com.bazinga.capital.job;

import com.bazinga.capital.api.QuoteApiService;
import com.bazinga.capital.constant.LoginState;
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
public class SubscribeAllMarketDataJob {

    @Autowired
    private QuoteApiService quoteApiService;

    public void execute() {
        log.info("SubscribeAllMarketDataJob start...");
        try {
            if (LoginState.LOGIN_RESULT) {
                quoteApiService.subscribeAllMarketData(ExchangeType.SZ.getType());
            } else {
                log.info("未登录 ---------->");
            }
            TimeUnit.SECONDS.sleep(3600);
        } catch (Exception e) {
            log.error("SubscribeAllMarketDataJob error", e);
        }
        log.info("SubscribeAllMarketDataJob end ");
    }
}
