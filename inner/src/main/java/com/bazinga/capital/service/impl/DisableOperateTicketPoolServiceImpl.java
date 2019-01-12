package com.bazinga.capital.service.impl;

import com.bazinga.capital.dao.DisableOperateTicketPoolDAO;
import com.bazinga.capital.model.DisableOperateTicketPool;
import com.bazinga.capital.query.DisableOperateTicketPoolQuery;
import com.bazinga.capital.service.DisableOperateTicketPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈禁止操作池 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
@Service
public class DisableOperateTicketPoolServiceImpl implements DisableOperateTicketPoolService {

    @Autowired
    private DisableOperateTicketPoolDAO disableOperateTicketPoolDAO;

    @Override
    public DisableOperateTicketPool save(DisableOperateTicketPool record) {
        Assert.notNull(record, "待插入记录不能为空");
        record.setCreateTime(new Date());
        disableOperateTicketPoolDAO.insert(record);
        return record;
    }

    @Override
    public DisableOperateTicketPool getById(Long id) {
        Assert.notNull(id, "主键不能为空");
        return disableOperateTicketPoolDAO.selectByPrimaryKey(id);
    }

    @Override
    public DisableOperateTicketPool selectByTickerAndDay(String ticker, String day) {
        Assert.notNull(ticker, "股票代码不能为空");
        Assert.notNull(day, " 日期不能为空");
        Map<String, String> paramMap = new HashMap<>(4);
        paramMap.put("ticker", ticker);
        paramMap.put("day", day);
        return disableOperateTicketPoolDAO.selectByTickerAndDay(paramMap);
    }

    @Override
    public int updateByTickerAndDay(DisableOperateTicketPool record) {
        Assert.notNull(record, "更新对象不能为空");
        Assert.notNull(record.getTicker(), "股票代码不能为空");
        Assert.notNull(record.getDay(), " 日期不能为空");
        return disableOperateTicketPoolDAO.updateByTickerAndDay(record);
    }

    @Override
    public int updateById(DisableOperateTicketPool record) {
        Assert.notNull(record, "待更新记录不能为空");
        record.setUpdateTime(new Date());
        return disableOperateTicketPoolDAO.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<DisableOperateTicketPool> listByCondition(DisableOperateTicketPoolQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return disableOperateTicketPoolDAO.selectByCondition(query);
    }

    @Override
    public int countByCondition(DisableOperateTicketPoolQuery query) {
        Assert.notNull(query, "查询条件不能为空");
        return disableOperateTicketPoolDAO.countByCondition(query);
    }
}