package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.DisableInsertTicketDAO;
import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.query.DisableInsertTicketQuery;
import com.bazinga.capital.service.DisableInsertTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈DisableInsertTicket Service〉<p>
 * 〈功能详细描述〉
 *
 * @author yunshan
 * @date 2019-01-09
 */
@Service
public class DisableInsertTicketServiceImpl implements DisableInsertTicketService {

    @Autowired
    private DisableInsertTicketDAO disableInsertTicketDAO;

    @Override
    public DisableInsertTicket save(DisableInsertTicket record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        disableInsertTicketDAO.insert(record);
        return record;
    }

    @Override
    public DisableInsertTicket getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return disableInsertTicketDAO.selectByPrimaryKey(id);
    }

    @Override
    public int updateById(DisableInsertTicket record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return disableInsertTicketDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DisableInsertTicket> listByCondition(DisableInsertTicketQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return disableInsertTicketDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(DisableInsertTicketQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return disableInsertTicketDAO.countByCondition(query);
    }

    @Override
    public DisableInsertTicket getByTickerAndDay(String ticker, String day) {
        Assert.notNull(ticker, "股票代码不能为空");
        Assert.notNull(day, "日期不能为空");
        Map<String, String> paramMap = new HashMap<>(4);
        paramMap.put("ticker", ticker);
        paramMap.put("day", day);
        return disableInsertTicketDAO.selectByTickerAndDay(paramMap);
    }

    @Override
    public int updateByTickerAndDay(DisableInsertTicket record) {
        Assert.notNull(record, "待更新记录不能为空");
        Assert.hasText(record.getTicker(), "股票代码不能为空");
        Assert.hasText(record.getDay(), "日期不能为空");
        return disableInsertTicketDAO.updateByTickerAndDay(record);
    }
}