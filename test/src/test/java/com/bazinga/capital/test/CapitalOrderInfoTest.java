package com.bazinga.capital.test;

import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.query.CapitalOrderInfoQuery;
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
* 〈 本地订单信息  Test〉<p>
* 〈单元测试〉
*
* @author yunshan
* @date 2019-01-06
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CapitalOrderInfoTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(CapitalOrderInfoTest.class);

    @Resource
    private CapitalOrderInfoService capitalOrderInfoService;

    @Test
    public void add(){
        CapitalOrderInfo capitalOrderInfo = new CapitalOrderInfo();
        capitalOrderInfo.setTicker(null);
        capitalOrderInfo.setTicketName(null);
        capitalOrderInfo.setExchangeType(null);
        capitalOrderInfo.setOrderXtpId(null);
        capitalOrderInfo.setQuantity(null);
        capitalOrderInfo.setTradedQuantity(null);
        capitalOrderInfo.setOrderPrice(null);
        capitalOrderInfo.setStatus(null);
        capitalOrderInfo.setCreateTime(new Date());
        capitalOrderInfo.setUpdateTime(null);

        CapitalOrderInfo result = capitalOrderInfoService.save(capitalOrderInfo);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        CapitalOrderInfo capitalOrderInfo = capitalOrderInfoService.getById(null);
        LOGGER.info(capitalOrderInfo.toString());
    }

    @Test
    public void getByCondition(){
        CapitalOrderInfoQuery query=new CapitalOrderInfoQuery();


        List<CapitalOrderInfo> capitalOrderInfos = capitalOrderInfoService.listByCondition(query);
        LOGGER.info("query total size: " + capitalOrderInfos.size());

    }

    @Test
    public void updateById(){
        CapitalOrderInfo capitalOrderInfo = capitalOrderInfoService.getById(null);
        capitalOrderInfo.setTicker(null);
        capitalOrderInfo.setTicketName(null);
        capitalOrderInfo.setExchangeType(null);
        capitalOrderInfo.setOrderXtpId(null);
        capitalOrderInfo.setQuantity(null);
        capitalOrderInfo.setTradedQuantity(null);
        capitalOrderInfo.setOrderPrice(null);
        capitalOrderInfo.setStatus(null);
        capitalOrderInfo.setUpdateTime(null);

        int result = capitalOrderInfoService.updateById(capitalOrderInfo);
        Assert.assertTrue(result > 0);
    }
}