package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈系统订单信息 查询参数〉<p>
 *
 * @author
 * @date 2019-01-06
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class CapitalOrderInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    private String ticker;

    /**
     * 股票名称
     */
    private String ticketName;

    /**
     * 交易所类型 上海 1， 深圳 2， 未知 3
     */
    private Integer exchangeType;

    /**
     * xtp 订单号
     */
    private String orderXtpId;

    /**
     * 下单数量
     */
    private Integer quantity;

    /**
     * 成交数量
     */
    private Integer tradedQuantity;

    /**
     * 下单价格
     */
    private BigDecimal orderPrice;

    /**
     * 订单 状态 1  本地初始化, 2 xtp 系统初始化,3 未成交, 4 全部成交,5 部分成交,6 全部撤单, 7部分撤单
     */
    private Integer status;

    /**
     * 0 可以下单  1 禁止下单
     */
    private Integer stopInsert;

    /**
     * 0 允许撤单, 1 禁止撤单
     */
    private Integer stopCancel;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;

    /**
     * 更新时间 开始
     */
    private Date updateTimeFrom;

    /**
     * 更新时间 结束
     */
    private Date updateTimeTo;

    /**
     * xtp 撤单号
     *
     * @最大长度   30
     * @允许为空   YES
     * @是否索引   NO
     */
    private String orderCancelXtpId;


}