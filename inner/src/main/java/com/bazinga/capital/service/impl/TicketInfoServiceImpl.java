package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.TicketInfoDAO;
import com.bazinga.capital.model.TicketInfo;
import com.bazinga.capital.query.TicketInfoQuery;
import com.bazinga.capital.service.TicketInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 〈股票信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-21
 */
@Service
public class TicketInfoServiceImpl implements TicketInfoService {

    @Autowired
    private TicketInfoDAO ticketInfoDAO;

    @Override
    public TicketInfo save(TicketInfo record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        ticketInfoDAO.insert(record);
        return record;
    }

    @Override
    public TicketInfo getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return ticketInfoDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(TicketInfo record) {
        Assert.notNull(record, "待更新记录不能为空");
        return ticketInfoDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TicketInfo> listByCondition(TicketInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return ticketInfoDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(TicketInfoQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return ticketInfoDAO.countByCondition(query);
    }
}