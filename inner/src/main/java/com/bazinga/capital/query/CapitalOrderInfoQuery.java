package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈本地订单信息 查询参数〉<p>
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

}