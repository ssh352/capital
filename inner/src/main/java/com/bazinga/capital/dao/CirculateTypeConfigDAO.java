package com.bazinga.capital.dao;

import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.query.CirculateTypeConfigQuery;

import java.util.List;

/**
 * 〈股票类型配置信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-06
 */
public interface CirculateTypeConfigDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(CirculateTypeConfig record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    CirculateTypeConfig selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(CirculateTypeConfig record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CirculateTypeConfig> selectByCondition(CirculateTypeConfigQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(CirculateTypeConfigQuery query);

}