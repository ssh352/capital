package com.bazinga.capital.api.impl;

import com.bazinga.capital.dao.DepthMarketDataDAO;
import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.query.DepthMarketDataQuery;
import com.bazinga.capital.api.DepthMarketDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈普通行情 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-21
 */
@Service
public class DepthMarketDataServiceImpl implements DepthMarketDataService {

    @Autowired
    private DepthMarketDataDAO depthMarketDataDAO;

    @Override
    public DepthMarketData save(DepthMarketData record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        depthMarketDataDAO.insert(record);
        return record;
    }

    @Override
    public DepthMarketData getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return depthMarketDataDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(DepthMarketData record) {
        Assert.notNull(record, "待更新记录不能为空");
        return depthMarketDataDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DepthMarketData> listByCondition(DepthMarketDataQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return depthMarketDataDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(DepthMarketDataQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return depthMarketDataDAO.countByCondition(query);
    }
}