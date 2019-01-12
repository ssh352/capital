package com.bazinga.capital.service;

import com.bazinga.capital.model.CheckCancelOrderPool;
import com.bazinga.capital.query.CheckCancelOrderPoolQuery;

import java.util.List;

/**
 * 〈撤单判断池 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
public interface CheckCancelOrderPoolService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    CheckCancelOrderPool save(CheckCancelOrderPool record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    CheckCancelOrderPool getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(CheckCancelOrderPool record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CheckCancelOrderPool> listByCondition(CheckCancelOrderPoolQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(CheckCancelOrderPoolQuery query);
}