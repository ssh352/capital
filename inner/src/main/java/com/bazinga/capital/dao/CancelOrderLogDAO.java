package com.bazinga.capital.dao;

import com.bazinga.capital.model.CancelOrderLog;
import com.bazinga.capital.query.CancelOrderLogQuery;

import java.util.List;

/**
 * 〈撤单日志 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
public interface CancelOrderLogDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(CancelOrderLog record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    CancelOrderLog selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(CancelOrderLog record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CancelOrderLog> selectByCondition(CancelOrderLogQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(CancelOrderLogQuery query);

}