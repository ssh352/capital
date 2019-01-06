package com.bazinga.capital.test;

import com.bazinga.capital.constant.CommonConstant;
import com.bazinga.capital.enums.TickerTypeEnum;
import com.bazinga.capital.model.CirculateInfo;
import com.bazinga.capital.service.CirculateInfoService;
import com.bazinga.capital.query.CirculateInfoQuery;
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
 * 〈 流通信息  Test〉<p>
 * 〈单元测试〉
 *
 * @author
 * @date 2018-12-28
 */
@ContextConfiguration(locations = "classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CirculateInfoTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CirculateInfoTest.class);

    @Resource
    private CirculateInfoService circulateInfoService;

    @Test
    public void add() {
        CirculateInfo circulateInfo = new CirculateInfo();
        circulateInfo.setTicker(null);
        circulateInfo.setTickerName(null);
        circulateInfo.setCirculate(null);
        circulateInfo.setCirculateZ(null);
        circulateInfo.setCirculateType(null);
        circulateInfo.setChangeTime(null);

        CirculateInfo result = circulateInfoService.save(circulateInfo);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById() {
        CirculateInfo circulateInfo = circulateInfoService.getById(null);
        LOGGER.info(circulateInfo.toString());
    }

    @Test
    public void getByCondition() {
        CirculateInfoQuery query = new CirculateInfoQuery();
        List<CirculateInfo> circulateInfos = circulateInfoService.listByCondition(query);
        circulateInfos.forEach(item->{
            CirculateInfo forUpdate = new CirculateInfo();
            if(item.getCirculateZ()< 1* CommonConstant.ONE_HUNDRED_MILLION){
                forUpdate.setId(item.getId());
                forUpdate.setCirculateType(TickerTypeEnum.MIN.getCode());
            }else if(item.getCirculateZ()>= 1* CommonConstant.ONE_HUNDRED_MILLION &&
                    item.getCirculateZ()< 3* CommonConstant.ONE_HUNDRED_MILLION){
                forUpdate.setId(item.getId());
                forUpdate.setCirculateType(TickerTypeEnum.MEDIUM.getCode());
            }else if(item.getCirculateZ()>= 3* CommonConstant.ONE_HUNDRED_MILLION &&
                    item.getCirculateZ()< 8* CommonConstant.ONE_HUNDRED_MILLION){
                forUpdate.setId(item.getId());
                forUpdate.setCirculateType(TickerTypeEnum.MEDIUM.getCode());
            }else {
                forUpdate.setId(item.getId());
                forUpdate.setCirculateType(TickerTypeEnum.HUGE.getCode());
            }
            circulateInfoService.updateById(forUpdate);
        });
        LOGGER.info("query total size: " + circulateInfos.size());

    }

    @Test
    public void updateById() {
        CirculateInfo circulateInfo = circulateInfoService.getById(null);
        circulateInfo.setTicker(null);
        circulateInfo.setTickerName(null);
        circulateInfo.setCirculate(null);
        circulateInfo.setCirculateZ(null);
        circulateInfo.setCirculateType(null);
        circulateInfo.setChangeTime(null);

        int result = circulateInfoService.updateById(circulateInfo);
        Assert.assertTrue(result < 1* CommonConstant.ONE_HUNDRED_MILLION);
    }

    public static void main(String[] args) {
        System.out.println(10^8);
    }
}