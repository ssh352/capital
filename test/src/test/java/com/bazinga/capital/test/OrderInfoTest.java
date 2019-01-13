package com.bazinga.capital.test;

import com.bazinga.capital.component.OrderInfoPersistComponent;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.service.OrderInfoService;
import com.bazinga.capital.query.OrderInfoQuery;
import com.bazinga.capital.util.DateUtil;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
* 〈 订单信息  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2018-12-22
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderInfoTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInfoTest.class);

    @Resource
    private OrderInfoService orderInfoService;

    @Autowired
    private OrderInfoPersistComponent orderInfoPersistComponent;

    @Autowired
    private CapitalOrderInfoService capitalOrderInfoService;

    @Test
    public void test(){
        OrderInfoQuery query = new OrderInfoQuery();
        Date createTimeFrom = DateUtil.parseDate("2019-01-11 00:00:00", DateUtil.DEFAULT_FORMAT);
        Date createTimeTo = DateUtil.parseDate("2019-01-11 23:59:59", DateUtil.DEFAULT_FORMAT);
        query.setCreateTimeFrom(createTimeFrom);
        query.setCreateTimeTo(createTimeTo);
        List<OrderInfo> orderInfos = orderInfoService.listByCondition(query);
        orderInfos.forEach(item->{
            CapitalOrderInfo byOrderXtpId = capitalOrderInfoService.getByOrderXtpId(item.getOrderXtpId());
            if(byOrderXtpId==null){
                CapitalOrderInfo capitalOrderInfo = orderInfoPersistComponent.buildCapitalOrderInfo(item);
                capitalOrderInfoService.save(capitalOrderInfo);
            }else{
                byOrderXtpId.setCancelTime(item.getCancelTime());
                byOrderXtpId.setTradedQuantity(item.getQtyTraded().intValue());
                byOrderXtpId.setOrderCancelXtpId(ObjectUtils.toString(item.getOrderCancelXtpId(),""));
                capitalOrderInfoService.updateByOrderXtpId(byOrderXtpId);
            }
        });
    }

    @Test
    public void add(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setBusinessType(1);
        orderInfo.setCancelTime(new Date());
        orderInfo.setInsertTime(new Date());
        orderInfo.setMarketType(1);
        orderInfo.setOrderCancelClientId(2131);
        orderInfo.setOrderCancelXtpId(12312);
        orderInfo.setOrderClientId(13123);
        orderInfo.setOrderLocalId("31231");
        orderInfo.setOrderStatusType(1);
        orderInfo.setOrderSubmitStatusType(1);
        orderInfo.setOrderXtpId("23112");
        orderInfo.setPositionEffectType(1);
        orderInfo.setPrice(new BigDecimal("1.01"));
        orderInfo.setPriceType(1);
        orderInfo.setQtyLeft(1L);
        orderInfo.setQtyTraded(2313L);
        orderInfo.setQuantity(231L);
        orderInfo.setRequestId(543231L);
        orderInfo.setSideType(1);
        orderInfo.setTicker("423123");
        orderInfo.setTradeAmount(new BigDecimal("21313"));
        orderInfo.setTxtpOrderTypeType("2");
        orderInfo.setCreateTime(new Date());

        OrderInfo result = orderInfoService.save(orderInfo);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        OrderInfo orderInfo = orderInfoService.getById(null);
        LOGGER.info(orderInfo.toString());
    }

    @Test
    public void getByCondition(){
        OrderInfoQuery query=new OrderInfoQuery();
        List<OrderInfo> orderInfos = orderInfoService.listByCondition(query);
        LOGGER.info("query total size: " + orderInfos.size());

    }

    @Test
    public void updateById(){
        OrderInfo orderInfo = orderInfoService.getById(null);
        orderInfo.setBusinessType(null);
        orderInfo.setCancelTime(null);
        orderInfo.setInsertTime(null);
        orderInfo.setMarketType(null);
        orderInfo.setOrderCancelClientId(null);
        orderInfo.setOrderCancelXtpId(null);
        orderInfo.setOrderClientId(null);
        orderInfo.setOrderLocalId(null);
        orderInfo.setOrderStatusType(null);
        orderInfo.setOrderSubmitStatusType(null);
        orderInfo.setOrderXtpId(null);
        orderInfo.setPositionEffectType(null);
        orderInfo.setPrice(null);
        orderInfo.setPriceType(null);
        orderInfo.setQtyLeft(null);
        orderInfo.setQtyTraded(null);
        orderInfo.setQuantity(null);
        orderInfo.setRequestId(null);
        orderInfo.setSideType(null);
        orderInfo.setTicker(null);
        orderInfo.setTradeAmount(null);
        orderInfo.setTxtpOrderTypeType(null);

        int result = orderInfoService.updateById(orderInfo);
        Assert.assertTrue(result > 0);
    }
}