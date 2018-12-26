package com.bazinga.capital.test;

import com.bazinga.capital.job.*;
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

    @Autowired
    private InsertOrderJob insertOrderJob;

    @Autowired
    private QueryAssertJob queryAssertJob;
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

    @Test
    public void test4(){

        insertOrderJob.execute();
    }

    @Test
    public void test5(){
        queryAssertJob.execute();
    }
}
