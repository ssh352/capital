package com.bazinga.capital.test;

import com.bazinga.capital.model.CancelOrderLog;
import com.bazinga.capital.service.CancelOrderLogService;
import com.bazinga.capital.query.CancelOrderLogQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
* 〈 撤单日志  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2019-01-12
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CancelOrderLogTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(CancelOrderLogTest.class);

    @Resource
    private CancelOrderLogService cancelOrderLogService;

    @Test
    public void add(){
        CancelOrderLog cancelOrderLog = new CancelOrderLog();
        cancelOrderLog.setTicker(null);
        cancelOrderLog.setTickerName(null);
        cancelOrderLog.setOrderXtpId(null);
        cancelOrderLog.setStatus(null);
        cancelOrderLog.setRetryCount(null);
        cancelOrderLog.setCreateTime(new Date());
        cancelOrderLog.setUpdateTime(null);

        CancelOrderLog result = cancelOrderLogService.save(cancelOrderLog);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        CancelOrderLog cancelOrderLog = cancelOrderLogService.getById(null);
        LOGGER.info(cancelOrderLog.toString());
    }

    @Test
    public void getByCondition(){
        CancelOrderLogQuery query=new CancelOrderLogQuery();


        List<CancelOrderLog> cancelOrderLogs = cancelOrderLogService.listByCondition(query);
        LOGGER.info("query total size: " + cancelOrderLogs.size());

    }

    @Test
    public void updateById(){
        CancelOrderLog cancelOrderLog = cancelOrderLogService.getById(null);
        cancelOrderLog.setTicker(null);
        cancelOrderLog.setTickerName(null);
        cancelOrderLog.setOrderXtpId(null);
        cancelOrderLog.setStatus(null);
        cancelOrderLog.setRetryCount(null);
        cancelOrderLog.setUpdateTime(null);

        int result = cancelOrderLogService.updateById(cancelOrderLog);
        Assert.assertTrue(result > 0);
    }
}