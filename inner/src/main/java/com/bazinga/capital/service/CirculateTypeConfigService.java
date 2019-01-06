package com.bazinga.capital.service;

import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.query.CirculateTypeConfigQuery;

import java.util.List;

/**
 * 〈股票类型配置信息 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-06
 */
public interface CirculateTypeConfigService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    CirculateTypeConfig save(CirculateTypeConfig record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    CirculateTypeConfig getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(CirculateTypeConfig record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CirculateTypeConfig> listByCondition(CirculateTypeConfigQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(CirculateTypeConfigQuery query);
}