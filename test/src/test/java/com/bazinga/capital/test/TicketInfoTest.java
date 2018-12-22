package com.bazinga.capital.test;

import com.bazinga.capital.base.Sort;
import com.bazinga.capital.model.TicketInfo;
import com.bazinga.capital.api.TicketInfoService;
import com.bazinga.capital.query.TicketInfoQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Assert;

import javax.annotation.Resource;

/**
* 〈 股票信息  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2018-12-21
*/

public class TicketInfoTest extends BaseTestCase{

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketInfoTest.class);

    @Resource
    private TicketInfoService ticketInfoService;

    @Test
    public void add(){
        for(int i=0;i<10; i++){
            TicketInfo ticketInfo = new TicketInfo();
            ticketInfo.setTicker("132313213"+i);
            ticketInfo.setTicketName("fdfsadf"+i);
            ticketInfo.setExchangeType(1);
            ticketInfo.setTickerType(1);
            ticketInfo.setBuyQtyUnit(100);
            ticketInfo.setUpperLimitPrice(new BigDecimal("123"));
            ticketInfo.setLowerLimitPrice(new BigDecimal("313"));
            ticketInfo.setPreClosePrice(new BigDecimal("32213"));
            ticketInfo.setPriceTick(new BigDecimal("0.01"));
            ticketInfo.setCreateTime(new Date());
            TicketInfo result = ticketInfoService.save(ticketInfo);
            LOGGER.info(result.toString());
        }

    }

    @Test
    public void getById(){
        TicketInfo ticketInfo = ticketInfoService.getById(null);
        LOGGER.info(ticketInfo.toString());
    }

    @Test
    public void getByCondition(){
        TicketInfoQuery query=new TicketInfoQuery();
        query.addOrderBy("id", Sort.SortType.DESC);

        List<TicketInfo> ticketInfos = ticketInfoService.listByCondition(query);
        ticketInfos.forEach(item-> System.out.println(item));

    }

    @Test
    public void updateById(){
        TicketInfo ticketInfo = ticketInfoService.getById(null);
        ticketInfo.setTicker(null);
        ticketInfo.setTicketName(null);
        ticketInfo.setExchangeType(null);
        ticketInfo.setTickerType(null);
        ticketInfo.setBuyQtyUnit(null);
        ticketInfo.setUpperLimitPrice(null);
        ticketInfo.setLowerLimitPrice(null);
        ticketInfo.setPreClosePrice(null);
        ticketInfo.setPriceTick(null);

        int result = ticketInfoService.updateById(ticketInfo);
        Assert.assertTrue(result > 0);
    }
}