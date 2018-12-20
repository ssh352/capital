package com.bazinga.capital.test;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.base.Sort;
import com.bazinga.capital.model.UserInfo;
import com.bazinga.capital.query.UserInfoQuery;
import com.bazinga.capital.service.UserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 〈 用户测试  Test〉<p>
 * 〈单元测试〉
 *
 * @author
 * @date 2018-12-20
 */
public class UserInfoTest extends BaseTestCase {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoTest.class);

    @Resource
    private UserInfoService userInfoService;

    @Test
    public void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("hanBing");
        userInfo.setIdCard("21313212312");
        userInfo.setSex(1);
        userInfo.setBirthday(new Date());
        userInfo.setStatus(1);
        userInfo.setCreateTime(new Date());
        String modifier = "system";
        userInfo.setCreator("yunshan");
        userInfo.setModifyTime(new Date());
        userInfo.setModifier(modifier);
        userInfo.setIsDeleted(0);

        UserInfo result = userInfoService.save(userInfo);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById() {
        UserInfo userInfo = userInfoService.getById(null);
        LOGGER.info(userInfo.toString());
    }

    @Test
    public void getByCondition() {
        UserInfoQuery query = new UserInfoQuery();
        query.addOrderBy("id", Sort.SortType.DESC);
        LOGGER.info("queryParam={}", JSONObject.toJSONString(query));
        List<UserInfo> userInfos = userInfoService.listByCondition(query);
        userInfos.forEach(item -> System.out.println(item));

    }

    @Test
    public void updateById() {
        UserInfo userInfo = userInfoService.getById(null);
        userInfo.setName(null);
        userInfo.setIdCard(null);
        userInfo.setSex(null);
        userInfo.setBirthday(null);
        userInfo.setStatus(null);
        userInfo.setCreator(null);
        userInfo.setModifyTime(new Date());
        String modifier = "system";

        userInfo.setModifier(modifier);
        userInfo.setIsDeleted(null);

        int result = userInfoService.updateById(userInfo);
        Assert.assertTrue(result > 0);
    }
}