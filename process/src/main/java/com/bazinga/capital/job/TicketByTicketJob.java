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
public class TicketByTicketJob {

    @Autowired
    private QuoteApiService quoteApiService;

    public void execute() {
        log.info("TicketByTicketJob start...");
        try {
            quoteApiService.subscribeAllTickByTick(ExchangeType.SZ.getType());
            TimeUnit.SECONDS.sleep(30);
        } catch (Exception e) {
            log.error("TicketByTicketJob error", e);
        }
        log.info("TicketByTicketJob end ");
    }


}
