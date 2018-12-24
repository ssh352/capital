package com.bazinga.capital.test;

import com.bazinga.capital.job.QueryAllTicketJob;
import com.bazinga.capital.job.SubscribeAllMarketDataJob;
import com.bazinga.capital.job.SubscribeMarketDataJob;
import com.bazinga.capital.job.TicketByTicketJob;
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

    @Autowired
    private TicketByTicketJob ticketByTicketJob;

    @Autowired
    private SubscribeMarketDataJob subscribeMarketDataJob;
    @Test
    public void test(){
        log.info("job start");
        queryAllTicketJob.execute();
    }

    @Test
    public  void test1(){
        subscribeAllMarketDataJob.execute();
    }

    @Test
    public void test2(){
        ticketByTicketJob.execute();
    }

    @Test
    public void test3(){
        subscribeMarketDataJob.execute();
    }
}
