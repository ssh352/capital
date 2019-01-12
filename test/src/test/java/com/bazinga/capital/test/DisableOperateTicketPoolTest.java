package com.bazinga.capital.test;

import com.bazinga.capital.model.DisableOperateTicketPool;
import com.bazinga.capital.service.DisableOperateTicketPoolService;
import com.bazinga.capital.query.DisableOperateTicketPoolQuery;
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
* 〈 禁止操作池  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2019-01-12
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DisableOperateTicketPoolTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(DisableOperateTicketPoolTest.class);

    @Resource
    private DisableOperateTicketPoolService disableOperateTicketPoolService;

    @Test
    public void add(){
        DisableOperateTicketPool disableOperateTicketPool = new DisableOperateTicketPool();
        disableOperateTicketPool.setTicker(null);
        disableOperateTicketPool.setTickerName(null);
        disableOperateTicketPool.setDay(null);

        disableOperateTicketPool.setCreateTime(new Date());
        disableOperateTicketPool.setUpdateTime(null);

        DisableOperateTicketPool result = disableOperateTicketPoolService.save(disableOperateTicketPool);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        DisableOperateTicketPool disableOperateTicketPool = disableOperateTicketPoolService.getById(null);
        LOGGER.info(disableOperateTicketPool.toString());
    }

    @Test
    public void getByCondition(){
        DisableOperateTicketPoolQuery query=new DisableOperateTicketPoolQuery();
        query.setTicker(null);
        query.setTickerName(null);

        query.setCreateTimeFrom(null);
        query.setCreateTimeTo(null);

        List<DisableOperateTicketPool> disableOperateTicketPools = disableOperateTicketPoolService.listByCondition(query);
        LOGGER.info("query total size: " + disableOperateTicketPools.size());

    }

    @Test
    public void updateById(){
        DisableOperateTicketPool disableOperateTicketPool = disableOperateTicketPoolService.getById(null);
        disableOperateTicketPool.setTicker(null);
        disableOperateTicketPool.setTickerName(null);
        disableOperateTicketPool.setDay(null);

        disableOperateTicketPool.setUpdateTime(null);

        int result = disableOperateTicketPoolService.updateById(disableOperateTicketPool);
        Assert.assertTrue(result > 0);
    }
}