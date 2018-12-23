package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈逐笔委托 查询参数〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class TickByTickEntrustQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 频道代码
     */
    private Integer channelNo;

    /**
     * 订单类别: 1: 市价; 2: 限价; 3: 本方最优
     */
    private String ordType;

    /**
     * 委托价格
     */
    private BigDecimal price;

    /**
     * 委托数量
     */
    private Long qty;

    /**
     * 委托序号(在同一个channel_no内唯一，从1开始连续)
     */
    private Long seq;

    /**
     * 1:买; 2:卖; G:借入; F:出借
     */
    private String side;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;


}