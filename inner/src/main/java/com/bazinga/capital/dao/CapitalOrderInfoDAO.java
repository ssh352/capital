package com.bazinga.capital.dao;

import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.query.CapitalOrderInfoQuery;

import java.util.List;

/**
 * 〈系统订单信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-06
 */
public interface CapitalOrderInfoDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(CapitalOrderInfo record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    CapitalOrderInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(CapitalOrderInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<CapitalOrderInfo> selectByCondition(CapitalOrderInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(CapitalOrderInfoQuery query);

}