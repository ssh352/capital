package com.bazinga.capital.test;

import com.bazinga.capital.model.CheckCancelOrderPool;
import com.bazinga.capital.service.CheckCancelOrderPoolService;
import com.bazinga.capital.query.CheckCancelOrderPoolQuery;
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
* 〈 撤单判断池  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2019-01-12
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckCancelOrderPoolTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckCancelOrderPoolTest.class);

    @Resource
    private CheckCancelOrderPoolService checkCancelOrderPoolService;

    @Test
    public void add(){
        CheckCancelOrderPool checkCancelOrderPool = new CheckCancelOrderPool();
        checkCancelOrderPool.setTicker(null);
        checkCancelOrderPool.setTickerName(null);
        checkCancelOrderPool.setOrderXtpId(null);
        checkCancelOrderPool.setCreateTime(new Date());
        checkCancelOrderPool.setUpdateTime(null);

        CheckCancelOrderPool result = checkCancelOrderPoolService.save(checkCancelOrderPool);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        CheckCancelOrderPool checkCancelOrderPool = checkCancelOrderPoolService.getById(null);
        LOGGER.info(checkCancelOrderPool.toString());
    }

    @Test
    public void getByCondition(){
        CheckCancelOrderPoolQuery query=new CheckCancelOrderPoolQuery();


        List<CheckCancelOrderPool> checkCancelOrderPools = checkCancelOrderPoolService.listByCondition(query);
        LOGGER.info("query total size: " + checkCancelOrderPools.size());

    }

    @Test
    public void updateById(){
        CheckCancelOrderPool checkCancelOrderPool = checkCancelOrderPoolService.getById(null);
        checkCancelOrderPool.setTicker(null);
        checkCancelOrderPool.setTickerName(null);
        checkCancelOrderPool.setOrderXtpId(null);
        checkCancelOrderPool.setUpdateTime(null);

        int result = checkCancelOrderPoolService.updateById(checkCancelOrderPool);
        Assert.assertTrue(result > 0);
    }
}