package com.bazinga.capital.dao;

import com.bazinga.capital.model.TickByTickEntrust;
import com.bazinga.capital.query.TickByTickEntrustQuery;

import java.util.List;

/**
 * 〈逐笔委托 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
public interface TickByTickEntrustDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(TickByTickEntrust record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    TickByTickEntrust selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(TickByTickEntrust record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<TickByTickEntrust> selectByCondition(TickByTickEntrustQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(TickByTickEntrustQuery query);

}