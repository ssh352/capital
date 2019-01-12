package com.bazinga.capital.dao;

import com.bazinga.capital.model.CheckCancelOrderPool;
import com.bazinga.capital.query.CheckCancelOrderPoolQuery;

import java.util.List;

/**
 * 〈撤单判断池 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
public interface CheckCancelOrderPoolDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(CheckCancelOrderPool record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    CheckCancelOrderPool selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(CheckCancelOrderPool record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CheckCancelOrderPool> selectByCondition(CheckCancelOrderPoolQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(CheckCancelOrderPoolQuery query);

}