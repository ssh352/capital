package com.bazinga.capital.test;

import com.bazinga.capital.job.QueryAllTicketJob;
import com.bazinga.capital.job.SubscribeAllMarketDataJob;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yunshan
 * @date 2018/12/21
 */
@Slf4j
public class JobTest extends BaseTestCase{

    @Autowired
    private QueryAllTicketJob queryAllTicketJob;

    @Autowired
    private SubscribeAllMarketDataJob subscribeAllMarketDataJob;

    @Test
    public void test(){
        log.info("job start");
        queryAllTicketJob.execute();
    }

    @Test
    public  void test1(){
        subscribeAllMarketDataJob.execute();
    }
}
