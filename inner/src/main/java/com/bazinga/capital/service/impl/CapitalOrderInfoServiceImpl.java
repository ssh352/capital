package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.CapitalOrderInfoDAO;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.query.CapitalOrderInfoQuery;
import com.bazinga.capital.service.CapitalOrderInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈111 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author yunshan
 * @date 2019-01-06
 */
@Service
public class CapitalOrderInfoServiceImpl implements CapitalOrderInfoService {

    @Autowired
    private CapitalOrderInfoDAO capitalOrderInfoDAO;

    @Override
    public CapitalOrderInfo save(CapitalOrderInfo record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        capitalOrderInfoDAO.insert(record);
        return record;
    }

    @Override
    public CapitalOrderInfo getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return capitalOrderInfoDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(CapitalOrderInfo record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return capitalOrderInfoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<CapitalOrderInfo> listByCondition(CapitalOrderInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return capitalOrderInfoDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(CapitalOrderInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return capitalOrderInfoDAO.countByCondition(query);
    }

    @Override
    public CapitalOrderInfo getByOrderXtpId(String orderXtpId) {
        Assert.notNull(orderXtpId, "唯一键不能为空");
        return capitalOrderInfoDAO.selectByOrderXtpId(orderXtpId);
    }

    @Override
    public int updateByOrderXtpId(CapitalOrderInfo record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return capitalOrderInfoDAO.updateByOrderXtpId(record);
    }
}