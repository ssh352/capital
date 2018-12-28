package com.bazinga.capital.test;

import com.bazinga.capital.model.DepthMarketDataEx;
import com.bazinga.capital.service.DepthMarketDataExService;
import com.bazinga.capital.query.DepthMarketDataExQuery;
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
* 〈 买一买一信息  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2018-12-28
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepthMarketDataExTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(DepthMarketDataExTest.class);

    @Resource
    private DepthMarketDataExService depthMarketDataExService;

    @Test
    public void add(){
        DepthMarketDataEx depthMarketDataEx = new DepthMarketDataEx();
        depthMarketDataEx.setAsk1Count(null);
        depthMarketDataEx.setAsk1Qty(null);
        depthMarketDataEx.setBid1Count(null);
        depthMarketDataEx.setBid1Qty(null);
        depthMarketDataEx.setMaxAsk1Count(null);
        depthMarketDataEx.setMaxBid1Count(null);
        depthMarketDataEx.setCreateTime(new Date());

        DepthMarketDataEx result = depthMarketDataExService.save(depthMarketDataEx);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        DepthMarketDataEx depthMarketDataEx = depthMarketDataExService.getById(null);
        LOGGER.info(depthMarketDataEx.toString());
    }

    @Test
    public void getByCondition(){
        DepthMarketDataExQuery query=new DepthMarketDataExQuery();
        query.setAsk1Count(null);
        query.setAsk1Qty(null);
        query.setBid1Count(null);
        query.setBid1Qty(null);
        query.setMaxAsk1Count(null);
        query.setMaxBid1Count(null);
        query.setCreateTimeFrom(null);
        query.setCreateTimeTo(null);

        List<DepthMarketDataEx> depthMarketDataExs = depthMarketDataExService.listByCondition(query);
        LOGGER.info("query total size: " + depthMarketDataExs.size());

    }

    @Test
    public void updateById(){
        DepthMarketDataEx depthMarketDataEx = depthMarketDataExService.getById(null);
        depthMarketDataEx.setAsk1Count(null);
        depthMarketDataEx.setAsk1Qty(null);
        depthMarketDataEx.setBid1Count(null);
        depthMarketDataEx.setBid1Qty(null);
        depthMarketDataEx.setMaxAsk1Count(null);
        depthMarketDataEx.setMaxBid1Count(null);

        int result = depthMarketDataExService.updateById(depthMarketDataEx);
        Assert.assertTrue(result > 0);
    }
}