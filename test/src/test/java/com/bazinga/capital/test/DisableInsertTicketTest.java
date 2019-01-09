package com.bazinga.capital.test;

import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.service.DisableInsertTicketService;
import com.bazinga.capital.query.DisableInsertTicketQuery;
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
 * 〈 DisableInsertTicket  Test〉<p>
 * 〈单元测试〉
 *
 * @author
 * @date 2019-01-09
 */
@ContextConfiguration(locations = "classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DisableInsertTicketTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisableInsertTicketTest.class);

    @Resource
    private DisableInsertTicketService disableInsertTicketService;

    @Test
    public void add() {
        DisableInsertTicket disableInsertTicket = new DisableInsertTicket();
        disableInsertTicket.setTicker(null);
        disableInsertTicket.setTickerName(null);
        disableInsertTicket.setDay(null);
        disableInsertTicket.setOperateType(null);
        disableInsertTicket.setCreateTime(new Date());
        disableInsertTicket.setUpdateTime(null);

        DisableInsertTicket result = disableInsertTicketService.save(disableInsertTicket);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById() {
        DisableInsertTicket disableInsertTicket = disableInsertTicketService.getById(null);
        LOGGER.info(disableInsertTicket.toString());
    }

    @Test
    public void getByCondition() {
        DisableInsertTicketQuery query = new DisableInsertTicketQuery();
        List<DisableInsertTicket> disableInsertTickets = disableInsertTicketService.listByCondition(query);
        LOGGER.info("query total size: " + disableInsertTickets.size());

    }

    @Test
    public void updateById() {
        DisableInsertTicket disableInsertTicket = disableInsertTicketService.getById(null);
        disableInsertTicket.setTicker(null);
        disableInsertTicket.setTickerName(null);
        disableInsertTicket.setDay(null);
        disableInsertTicket.setOperateType(null);
        disableInsertTicket.setUpdateTime(null);

        int result = disableInsertTicketService.updateById(disableInsertTicket);
        Assert.assertTrue(result > 0);
    }
}