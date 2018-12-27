package com.bazinga.capital.job;

import com.bazinga.capital.api.QuoteApiService;
import com.zts.xtp.common.enums.ExchangeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SubcribeOrderBookJob {

    @Autowired
    private QuoteApiService quoteApiService;


    public void execute(){
        try {
            quoteApiService.subscribeAllOrderBook(ExchangeType.SZ.getType());
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
