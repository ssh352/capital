package com.bazinga.capital.dao;

import com.bazinga.capital.model.DisableOperateTicketPool;
import com.bazinga.capital.query.DisableOperateTicketPoolQuery;

import java.util.List;
import java.util.Map;

/**
 * 〈禁止操作池 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
public interface DisableOperateTicketPoolDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(DisableOperateTicketPool record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    DisableOperateTicketPool selectByPrimaryKey(Long id);

    /**
     * 根据唯一键查询
     *
     * @param paramMap 唯一键
     */
    DisableOperateTicketPool  selectByTickerAndDay(Map<String,String> paramMap);

    /**
     * 根据唯一键更新
     *
     * @param record 更新对象
     */
    int updateByTickerAndDay(DisableOperateTicketPool record);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(DisableOperateTicketPool record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DisableOperateTicketPool> selectByCondition(DisableOperateTicketPoolQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(DisableOperateTicketPoolQuery query);

}