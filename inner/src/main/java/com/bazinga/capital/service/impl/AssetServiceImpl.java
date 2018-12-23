package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.AssetDAO;
import com.bazinga.capital.model.Asset;
import com.bazinga.capital.query.AssetQuery;
import com.bazinga.capital.service.AssetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈资产 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetDAO assetDAO;

    @Override
    public Asset save(Asset record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        assetDAO.insert(record);
        return record;
    }

    @Override
    public Asset getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return assetDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(Asset record) {
        Assert.notNull(record, "待更新记录不能为空");
        return assetDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Asset> listByCondition(AssetQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return assetDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(AssetQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return assetDAO.countByCondition(query);
    }
}