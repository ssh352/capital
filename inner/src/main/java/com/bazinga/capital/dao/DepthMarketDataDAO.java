package com.bazinga.capital.dao;

import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.query.DepthMarketDataQuery;

import java.util.List;

/**
 * 〈普通行情 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-21
 */
public interface DepthMarketDataDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(DepthMarketData record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    DepthMarketData selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(DepthMarketData record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DepthMarketData> selectByCondition(DepthMarketDataQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(DepthMarketDataQuery query);

}