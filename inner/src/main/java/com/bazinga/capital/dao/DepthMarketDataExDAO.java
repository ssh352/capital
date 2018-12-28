package com.bazinga.capital.dao;

import com.bazinga.capital.model.DepthMarketDataEx;
import com.bazinga.capital.query.DepthMarketDataExQuery;

import java.util.List;

/**
 * 〈买一买一信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-28
 */
public interface DepthMarketDataExDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(DepthMarketDataEx record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    DepthMarketDataEx selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(DepthMarketDataEx record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DepthMarketDataEx> selectByCondition(DepthMarketDataExQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(DepthMarketDataExQuery query);

}