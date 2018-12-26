package com.bazinga.capital.test;

import com.bazinga.capital.api.QuoteApiService;
import com.zts.xtp.common.enums.ExchangeType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2018/12/26
 */
public class ApiTest extends BaseTestCase {

    @Autowired
    private QuoteApiService quoteApiService;

    @Test
    public void test(){
        try {
            quoteApiService.subscribeAllOrderBook(ExchangeType.SZ.getType());
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
