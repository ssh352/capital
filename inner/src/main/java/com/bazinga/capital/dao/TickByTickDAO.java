package com.bazinga.capital.dao;

import com.bazinga.capital.model.TickByTick;
import com.bazinga.capital.query.TickByTickQuery;

import java.util.List;

/**
 * 〈逐笔委托 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
public interface TickByTickDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(TickByTick record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    TickByTick selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(TickByTick record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<TickByTick> selectByCondition(TickByTickQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(TickByTickQuery query);

}