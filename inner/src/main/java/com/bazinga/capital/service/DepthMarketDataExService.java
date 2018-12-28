package com.bazinga.capital.service;

import com.bazinga.capital.model.DepthMarketDataEx;
import com.bazinga.capital.query.DepthMarketDataExQuery;

import java.util.List;

/**
 * 〈买一买一信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-28
 */
public interface DepthMarketDataExService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    DepthMarketDataEx save(DepthMarketDataEx record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    DepthMarketDataEx getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(DepthMarketDataEx record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DepthMarketDataEx> listByCondition(DepthMarketDataExQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(DepthMarketDataExQuery query);
}