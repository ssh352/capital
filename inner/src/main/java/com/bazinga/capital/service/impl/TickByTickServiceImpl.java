package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.TickByTickDAO;
import com.bazinga.capital.model.TickByTick;
import com.bazinga.capital.query.TickByTickQuery;
import com.bazinga.capital.service.TickByTickService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈逐笔委托 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
@Service
public class TickByTickServiceImpl implements TickByTickService {

    @Autowired
    private TickByTickDAO tickByTickDAO;

    @Override
    public TickByTick save(TickByTick record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        tickByTickDAO.insert(record);
        return record;
    }

    @Override
    public TickByTick getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return tickByTickDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(TickByTick record) {
        Assert.notNull(record, "待更新记录不能为空");
        return tickByTickDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TickByTick> listByCondition(TickByTickQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return tickByTickDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(TickByTickQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return tickByTickDAO.countByCondition(query);
    }
}