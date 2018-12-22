package com.bazinga.capital.api.impl;

import com.bazinga.capital.dao.UserInfoDAO;
import com.bazinga.capital.model.UserInfo;
import com.bazinga.capital.query.UserInfoQuery;
import com.bazinga.capital.api.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈用户测试 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-20
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public UserInfo save(UserInfo record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        userInfoDAO.insert(record);
        return record;
    }

    @Override
    public UserInfo getById(Integer id) {
        Assert.notNull(id, "主键不能为空");
        return userInfoDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(UserInfo record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setModifyTime(new Date());
        return userInfoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<UserInfo> listByCondition(UserInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return userInfoDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(UserInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return userInfoDAO.countByCondition(query);
    }
}