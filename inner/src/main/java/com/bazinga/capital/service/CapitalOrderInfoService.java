package com.bazinga.capital.service;

import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.query.CapitalOrderInfoQuery;

import java.util.List;

/**
 * 〈本地订单信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-06
 */
public interface CapitalOrderInfoService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    CapitalOrderInfo save(CapitalOrderInfo record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    CapitalOrderInfo getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(CapitalOrderInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CapitalOrderInfo> listByCondition(CapitalOrderInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(CapitalOrderInfoQuery query);
}