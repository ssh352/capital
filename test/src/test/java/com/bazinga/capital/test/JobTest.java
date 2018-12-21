package com.bazinga.capital.test;

import com.bazinga.capital.job.QueryAllTicketJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yunshan
 * @date 2018/12/21
 */
@Slf4j
public class JobTest extends BaseTestCase{

    @Autowired
    private QueryAllTicketJob queryAllTicketJob;

    public void test(){
        log.info("job start");
        queryAllTicketJob.execute();
    }
}
