package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.CancelOrderLogDAO;
import com.bazinga.capital.model.CancelOrderLog;
import com.bazinga.capital.query.CancelOrderLogQuery;
import com.bazinga.capital.service.CancelOrderLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈撤单日志 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
@Service
public class CancelOrderLogServiceImpl implements CancelOrderLogService {

    @Autowired
    private CancelOrderLogDAO cancelOrderLogDAO;

    @Override
    public CancelOrderLog save(CancelOrderLog record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        cancelOrderLogDAO.insert(record);
        return record;
    }

    @Override
    public CancelOrderLog getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return cancelOrderLogDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(CancelOrderLog record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return cancelOrderLogDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<CancelOrderLog> listByCondition(CancelOrderLogQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return cancelOrderLogDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(CancelOrderLogQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return cancelOrderLogDAO.countByCondition(query);
    }
}