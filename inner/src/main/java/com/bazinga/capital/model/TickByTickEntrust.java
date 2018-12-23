package com.bazinga.capital.model;

import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈逐笔委托〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.ToString
public class TickByTickEntrust implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Long id;

    /**
     * 频道代码
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer channelNo;

    /**
     * 订单类别: 1: 市价; 2: 限价; 3: 本方最优
     *
     * @最大长度   5
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ordType;

    /**
     * 委托价格
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal price;

    /**
     * 委托数量
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long qty;

    /**
     * 委托序号(在同一个channel_no内唯一，从1开始连续)
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long seq;

    /**
     * 1:买; 2:卖; G:借入; F:出借
     *
     * @最大长度   5
     * @允许为空   NO
     * @是否索引   NO
     */
    private String side;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;


}