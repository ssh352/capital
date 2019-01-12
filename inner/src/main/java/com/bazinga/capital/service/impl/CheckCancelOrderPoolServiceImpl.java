package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.CheckCancelOrderPoolDAO;
import com.bazinga.capital.model.CheckCancelOrderPool;
import com.bazinga.capital.query.CheckCancelOrderPoolQuery;
import com.bazinga.capital.service.CheckCancelOrderPoolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈撤单判断池 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
@Service
public class CheckCancelOrderPoolServiceImpl implements CheckCancelOrderPoolService {

    @Autowired
    private CheckCancelOrderPoolDAO checkCancelOrderPoolDAO;

    @Override
    public CheckCancelOrderPool save(CheckCancelOrderPool record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        checkCancelOrderPoolDAO.insert(record);
        return record;
    }

    @Override
    public CheckCancelOrderPool getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return checkCancelOrderPoolDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(CheckCancelOrderPool record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return checkCancelOrderPoolDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<CheckCancelOrderPool> listByCondition(CheckCancelOrderPoolQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return checkCancelOrderPoolDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(CheckCancelOrderPoolQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return checkCancelOrderPoolDAO.countByCondition(query);
    }
}