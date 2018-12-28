package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.DepthMarketDataExDAO;
import com.bazinga.capital.model.DepthMarketDataEx;
import com.bazinga.capital.query.DepthMarketDataExQuery;
import com.bazinga.capital.service.DepthMarketDataExService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈买一买一信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-28
 */
@Service
public class DepthMarketDataExServiceImpl implements DepthMarketDataExService {

    @Autowired
    private DepthMarketDataExDAO depthMarketDataExDAO;

    @Override
    public DepthMarketDataEx save(DepthMarketDataEx record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        depthMarketDataExDAO.insert(record);
        return record;
    }

    @Override
    public DepthMarketDataEx getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return depthMarketDataExDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(DepthMarketDataEx record) {
        Assert.notNull(record, "待更新记录不能为空");
        return depthMarketDataExDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DepthMarketDataEx> listByCondition(DepthMarketDataExQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return depthMarketDataExDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(DepthMarketDataExQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return depthMarketDataExDAO.countByCondition(query);
    }
}