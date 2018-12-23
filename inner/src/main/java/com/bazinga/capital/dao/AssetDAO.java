package com.bazinga.capital.dao;

import com.bazinga.capital.model.Asset;
import com.bazinga.capital.query.AssetQuery;

import java.util.List;

/**
 * 〈资产 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
public interface AssetDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(Asset record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    Asset selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(Asset record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<Asset> selectByCondition(AssetQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(AssetQuery query);

}