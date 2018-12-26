package com.bazinga.capital.job;


import com.bazinga.capital.api.TradeApiService;
import com.zts.xtp.common.enums.ExchangeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class QueryAssertJob {

    @Autowired
    private TradeApiService tradeApiService;

    public void execute(){

        try {
            tradeApiService.queryAsset(ExchangeType.SZ.getType());
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


