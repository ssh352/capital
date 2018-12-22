package com.bazinga.capital.service;

import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.query.DepthMarketDataQuery;

import java.util.List;

/**
 * 〈普通行情 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-21
 */
public interface DepthMarketDataService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    DepthMarketData save(DepthMarketData record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    DepthMarketData getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(DepthMarketData record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DepthMarketData> listByCondition(DepthMarketDataQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(DepthMarketDataQuery query);
}