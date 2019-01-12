package com.bazinga.capital.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈系统订单信息〉<p>
 *
 * @author
 * @date 2019-01-12
 */
@lombok.Data
@lombok.ToString
public class CapitalOrderInfo implements Serializable {

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
     * 股票代码
     *
     * @最大长度   30
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticker;

    /**
     * 股票名称
     *
     * @最大长度   60
     * @允许为空   YES
     * @是否索引   NO
     */
    private String ticketName;

    /**
     * 交易所类型 上海 1， 深圳 2， 未知 3
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer exchangeType;

    /**
     * xtp 订单号
     *
     * @最大长度   30
     * @允许为空   YES
     * @是否索引   YES
     * @唯一索引   uk_order_xtp_id
     */
    private String orderXtpId;

    /**
     * xtp 撤单号
     *
     * @最大长度   30
     * @允许为空   YES
     * @是否索引   NO
     */
    private String orderCancelXtpId;

    /**
     * 下单数量
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer quantity;

    /**
     * 成交数量
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer tradedQuantity;

    /**
     * 下单价格
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal orderPrice;

    /**
     * 订单 状态 1  本地初始化, 2 xtp 系统初始化,3 未成交, 4 全部成交,5 部分成交,6 全部撤单, 7部分撤单
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer status;

    /**
     * 0 可以下单  1 禁止下单
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer stopInsert;

    /**
     * 0 允许撤单, 1 禁止撤单
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer stopCancel;

    /**
     * 撤单时间
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Date cancelTime;

    /**
     * 下单时间
     */
    private Date insertTime;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   YES
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Date updateTime;


}