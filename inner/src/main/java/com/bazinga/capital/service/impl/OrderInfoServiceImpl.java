package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.OrderInfoDAO;
import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.query.OrderInfoQuery;
import com.bazinga.capital.service.OrderInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈订单信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoDAO orderInfoDAO;

    @Override
    public OrderInfo save(OrderInfo record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        orderInfoDAO.insert(record);
        return record;
    }

    @Override
    public OrderInfo getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return orderInfoDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(OrderInfo record) {
        Assert.notNull(record, "待更新记录不能为空");
        return orderInfoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<OrderInfo> listByCondition(OrderInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return orderInfoDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(OrderInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return orderInfoDAO.countByCondition(query);
    }
}