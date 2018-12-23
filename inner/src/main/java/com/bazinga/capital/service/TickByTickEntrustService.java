package com.bazinga.capital.service;

import com.bazinga.capital.model.TickByTickEntrust;
import com.bazinga.capital.query.TickByTickEntrustQuery;

import java.util.List;

/**
 * 〈逐笔委托 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
public interface TickByTickEntrustService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    TickByTickEntrust save(TickByTickEntrust record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    TickByTickEntrust getById(Long id);

    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(TickByTickEntrust record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<TickByTickEntrust> listByCondition(TickByTickEntrustQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(TickByTickEntrustQuery query);
}