package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.TickByTickEntrustDAO;
import com.bazinga.capital.model.TickByTickEntrust;
import com.bazinga.capital.query.TickByTickEntrustQuery;
import com.bazinga.capital.service.TickByTickEntrustService;

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
public class TickByTickEntrustServiceImpl implements TickByTickEntrustService {

    @Autowired
    private TickByTickEntrustDAO tickByTickEntrustDAO;

    @Override
    public TickByTickEntrust save(TickByTickEntrust record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        tickByTickEntrustDAO.insert(record);
        return record;
    }

    @Override
    public TickByTickEntrust getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return tickByTickEntrustDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(TickByTickEntrust record) {
        Assert.notNull(record, "待更新记录不能为空");
        return tickByTickEntrustDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TickByTickEntrust> listByCondition(TickByTickEntrustQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return tickByTickEntrustDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(TickByTickEntrustQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return tickByTickEntrustDAO.countByCondition(query);
    }
}