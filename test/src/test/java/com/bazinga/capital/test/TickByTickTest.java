package com.bazinga.capital.test;

import com.bazinga.capital.model.TickByTick;
import com.bazinga.capital.service.TickByTickService;
import com.bazinga.capital.query.TickByTickQuery;
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
* 〈 逐笔委托  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2018-12-22
*/

public class TickByTickTest extends BaseTestCase{

    private static final Logger LOGGER = LoggerFactory.getLogger(TickByTickTest.class);

    @Resource
    private TickByTickService tickByTickService;

    @Test
    public void add(){
        TickByTick tickByTick = new TickByTick();
        tickByTick.setDatetime(String.valueOf(new Date().getTime()));
        tickByTick.setSeq(213213L);
        tickByTick.setTicker("322424");
        tickByTick.setEntrustId(213L);
        tickByTick.setExchangeType(1);
        tickByTick.setTradeId(321312L);
        tickByTick.setType(1);
        tickByTick.setCreateTime(new Date());

        TickByTick result = tickByTickService.save(tickByTick);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        TickByTick tickByTick = tickByTickService.getById(null);
        LOGGER.info(tickByTick.toString());
    }

    @Test
    public void getByCondition(){
        TickByTickQuery query=new TickByTickQuery();
        query.setDatetime(null);
        query.setSeq(null);
        query.setTicker(null);
        query.setEntrustId(null);
        query.setExchangeType(null);
        query.setTradeId(null);
        query.setType(null);
        query.setCreateTimeFrom(null);
        query.setCreateTimeTo(null);

        List<TickByTick> tickByTicks = tickByTickService.listByCondition(query);
        LOGGER.info("query total size: " + tickByTicks.size());

    }

    @Test
    public void updateById(){
        TickByTick tickByTick = tickByTickService.getById(null);
        tickByTick.setDatetime(null);
        tickByTick.setSeq(null);
        tickByTick.setTicker(null);
        tickByTick.setEntrustId(null);
        tickByTick.setExchangeType(null);
        tickByTick.setTradeId(null);
        tickByTick.setType(null);

        int result = tickByTickService.updateById(tickByTick);
        Assert.assertTrue(result > 0);
    }
}