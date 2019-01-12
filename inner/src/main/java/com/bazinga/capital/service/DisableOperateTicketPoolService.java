package com.bazinga.capital.service;

import com.bazinga.capital.model.DisableOperateTicketPool;
import com.bazinga.capital.query.DisableOperateTicketPoolQuery;

import java.util.List;
import java.util.Map;

/**
 * 〈禁止操作池 Service〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2019-01-12
 */
public interface DisableOperateTicketPoolService {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    DisableOperateTicketPool save(DisableOperateTicketPool record);

    /**
     * 根据ID查询
     *
     * @param id 数据库ID
     */
    DisableOperateTicketPool getById(Long id);

    /**
     * 根据唯一键查询
     * @param ticker 代码
     * @param day 日期
     * @return
     */
    DisableOperateTicketPool  selectByTickerAndDay(String ticker,String day);

    /**
     * 根据唯一键更新
     *
     * @param record 更新对象
     */
    int updateByTickerAndDay(DisableOperateTicketPool record);
    /**
     * 根据id更新一条数据
     *
     * @param record 更新参数
     */
    int updateById(DisableOperateTicketPool record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<DisableOperateTicketPool> listByCondition(DisableOperateTicketPoolQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    int countByCondition(DisableOperateTicketPoolQuery query);
}