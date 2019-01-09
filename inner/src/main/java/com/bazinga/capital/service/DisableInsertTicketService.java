package com.bazinga.capital.service;

import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.query.DisableInsertTicketQuery;

import java.util.List;

/**
 * 〈DisableInsertTicket Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-09
 */
public interface DisableInsertTicketService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    DisableInsertTicket save(DisableInsertTicket record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    DisableInsertTicket getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(DisableInsertTicket record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DisableInsertTicket> listByCondition(DisableInsertTicketQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(DisableInsertTicketQuery query);

    /**
     * 唯一键ticker 查询
     *
     * @param ticker 查询参数
     */
    DisableInsertTicket getByTickerAndDay(String ticker,String day);

    /**
     * 唯一键ticker 更新
     *
     * @param record 更新参数
     */
    int updateByTickerAndDay(DisableInsertTicket record);
}