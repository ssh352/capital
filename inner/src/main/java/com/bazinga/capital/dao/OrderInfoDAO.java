package com.bazinga.capital.dao;

import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.query.OrderInfoQuery;

import java.util.List;

/**
 * 〈订单信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2018-12-22
 */
public interface OrderInfoDAO {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(OrderInfo record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    OrderInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<OrderInfo> selectByCondition(OrderInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(OrderInfoQuery query);

}