package com.bazinga.capital.test;

import com.bazinga.capital.model.TickByTickEntrust;
import com.bazinga.capital.service.TickByTickEntrustService;
import com.bazinga.capital.query.TickByTickEntrustQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.math.BigDecimal;
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
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TickByTickEntrustTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(TickByTickEntrustTest.class);

    @Resource
    private TickByTickEntrustService tickByTickEntrustService;

    @Test
    public void add(){
        TickByTickEntrust tickByTickEntrust = new TickByTickEntrust();
        tickByTickEntrust.setChannelNo(123);
        tickByTickEntrust.setOrdType("3");
        tickByTickEntrust.setPrice(new BigDecimal("3123"));
        tickByTickEntrust.setQty(13L);
        tickByTickEntrust.setSeq(2131L);
        tickByTickEntrust.setSide("213");
        tickByTickEntrust.setCreateTime(new Date());

        TickByTickEntrust result = tickByTickEntrustService.save(tickByTickEntrust);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        TickByTickEntrust tickByTickEntrust = tickByTickEntrustService.getById(null);
        LOGGER.info(tickByTickEntrust.toString());
    }

    @Test
    public void getByCondition(){
        TickByTickEntrustQuery query=new TickByTickEntrustQuery();
        query.setChannelNo(null);
        query.setOrdType(null);
        query.setPrice(null);
        query.setQty(null);
        query.setSeq(null);
        query.setSide(null);
        query.setCreateTimeFrom(null);
        query.setCreateTimeTo(null);

        List<TickByTickEntrust> tickByTickEntrusts = tickByTickEntrustService.listByCondition(query);
        LOGGER.info("query total size: " + tickByTickEntrusts.size());

    }

    @Test
    public void updateById(){
        TickByTickEntrust tickByTickEntrust = tickByTickEntrustService.getById(null);
        tickByTickEntrust.setChannelNo(null);
        tickByTickEntrust.setOrdType(null);
        tickByTickEntrust.setPrice(null);
        tickByTickEntrust.setQty(null);
        tickByTickEntrust.setSeq(null);
        tickByTickEntrust.setSide(null);

        int result = tickByTickEntrustService.updateById(tickByTickEntrust);
        Assert.assertTrue(result > 0);
    }
}