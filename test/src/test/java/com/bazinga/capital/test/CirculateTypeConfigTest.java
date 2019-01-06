package com.bazinga.capital.test;

import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.service.CirculateTypeConfigService;
import com.bazinga.capital.query.CirculateTypeConfigQuery;
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
* 〈 股票类型配置信息  Test〉<p>
* 〈单元测试〉
*
* @author yusshan
* @date 2019-01-06
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CirculateTypeConfigTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(CirculateTypeConfigTest.class);

    @Resource
    private CirculateTypeConfigService circulateTypeConfigService;

    @Test
    public void add(){
        CirculateTypeConfig circulateTypeConfig1 = new CirculateTypeConfig();
        circulateTypeConfig1.setCirculateType(0);
        circulateTypeConfig1.setPercent(5);
        circulateTypeConfig1.setMinInsertQuantity(600000L);
        circulateTypeConfig1.setCheckCirculateDelay(10);
        CirculateTypeConfig result = circulateTypeConfigService.save(circulateTypeConfig1);

        CirculateTypeConfig circulateTypeConfig2 = new CirculateTypeConfig();
        circulateTypeConfig2.setCirculateType(1);
        circulateTypeConfig2.setPercent(3);
        circulateTypeConfig2.setMinInsertQuantity(600000L);
        circulateTypeConfig2.setCheckCirculateDelay(12);
        circulateTypeConfigService.save(circulateTypeConfig2);

        CirculateTypeConfig circulateTypeConfig3 = new CirculateTypeConfig();
        circulateTypeConfig3.setCirculateType(2);
        circulateTypeConfig3.setPercent(2);
        circulateTypeConfig3.setMinInsertQuantity(600000L);
        circulateTypeConfig3.setCheckCirculateDelay(15);
        circulateTypeConfigService.save(circulateTypeConfig3);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        CirculateTypeConfig circulateTypeConfig = circulateTypeConfigService.getById(null);
        LOGGER.info(circulateTypeConfig.toString());
    }

    @Test
    public void getByCondition(){
        CirculateTypeConfigQuery query=new CirculateTypeConfigQuery();


        List<CirculateTypeConfig> circulateTypeConfigs = circulateTypeConfigService.listByCondition(query);
        LOGGER.info("query total size: " + circulateTypeConfigs.size());

    }

    @Test
    public void updateById(){
        CirculateTypeConfig circulateTypeConfig = circulateTypeConfigService.getById(null);
        circulateTypeConfig.setCirculateType(null);
        circulateTypeConfig.setPercent(null);
        circulateTypeConfig.setMinInsertQuantity(null);
        circulateTypeConfig.setCheckCirculateDelay(null);
        circulateTypeConfig.setUpdateTime(null);

        int result = circulateTypeConfigService.updateById(circulateTypeConfig);
        Assert.assertTrue(result > 0);
    }
}