package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.CirculateTypeConfigDAO;
import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.query.CirculateTypeConfigQuery;
import com.bazinga.capital.service.CirculateTypeConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈股票类型配置信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author yunshan
 * @date 2019-01-06
 */
@Service
public class CirculateTypeConfigServiceImpl implements CirculateTypeConfigService {

    @Autowired
    private CirculateTypeConfigDAO circulateTypeConfigDAO;

    @Override
    public CirculateTypeConfig save(CirculateTypeConfig record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        circulateTypeConfigDAO.insert(record);
        return record;
    }

    @Override
    public CirculateTypeConfig getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return circulateTypeConfigDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(CirculateTypeConfig record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return circulateTypeConfigDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<CirculateTypeConfig> listByCondition(CirculateTypeConfigQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return circulateTypeConfigDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(CirculateTypeConfigQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return circulateTypeConfigDAO.countByCondition(query);
    }
}