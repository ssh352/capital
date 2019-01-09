package com.bazinga.capital.dao;

import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.query.DisableInsertTicketQuery;

import java.util.List;
import java.util.Map;

/**
 * 〈DisableInsertTicket DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-09
 */
public interface DisableInsertTicketDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(DisableInsertTicket record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    DisableInsertTicket selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(DisableInsertTicket record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DisableInsertTicket> selectByCondition(DisableInsertTicketQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(DisableInsertTicketQuery query);

    /**
     * 唯一键ticker 查询
     *
     * @param paramMap 查询参数
     */
    DisableInsertTicket selectByTickerAndDay(Map<String, String> paramMap);

    /**
     * 唯一键ticker 更新
     *
     * @param record 更新参数
     */
    int updateByTickerAndDay(DisableInsertTicket record);

}