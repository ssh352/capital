package com.bazinga.capital.service;

import com.bazinga.capital.model.CancelOrderLog;
import com.bazinga.capital.query.CancelOrderLogQuery;

import java.util.List;

/**
 * 〈撤单日志 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
public interface CancelOrderLogService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    CancelOrderLog save(CancelOrderLog record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    CancelOrderLog getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(CancelOrderLog record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CancelOrderLog> listByCondition(CancelOrderLogQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(CancelOrderLogQuery query);
}