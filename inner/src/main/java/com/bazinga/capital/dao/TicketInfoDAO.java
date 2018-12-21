package com.bazinga.capital.dao;

import com.bazinga.capital.model.TicketInfo;
import com.bazinga.capital.query.TicketInfoQuery;

import java.util.List;

/**
 * 〈股票信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-21
 */
public interface TicketInfoDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(TicketInfo record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    TicketInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(TicketInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<TicketInfo> selectByCondition(TicketInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(TicketInfoQuery query);

}