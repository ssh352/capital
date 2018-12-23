package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈订单信息 查询参数〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class OrderInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务类型 普通股票业务 1 新股申购业务 2 回购业务 3 
     */
    private Integer businessType;

    /**
     * 撤销时间 开始
     */
    private Date cancelTimeFrom;

    /**
     * 撤销时间 结束
     */
    private Date cancelTimeTo;

    /**
     * 委托时间 开始
     */
    private Date insertTimeFrom;

    /**
     * 委托时间 结束
     */
    private Date insertTimeTo;

    /**
     * 初始化值或者未知 0 上海A股 1 深圳A股 2 未知交易市场类型 3
     */
    private Integer marketType;

    /**
     * 报单操作引用，用户自定义
     */
    private Integer orderCancelClientId;

    /**
     * 撤单在XTP系统中的id，在XTP系统中唯一
     */
    private Integer orderCancelXtpId;

    /**
     * 报单引用，用户自定义
     */
    private Integer orderClientId;

    /**
     * 本地报单编号 OMS生成的单号，不等同于order_xtp_id，为服务器传到报盘的单号
     */
    private String orderLocalId;

    /**
     * 报单状态类型 0 全部成交, 1 已撤单, 2 初始化, 3 未成交, 4部分撤单,5 部分成交,6 已拒绝, 7 未知订单状态 
     */
    private Integer orderStatusType;

    /**
     * 报单提交状态 1 撤单已经被接受,2撤单已经被拒绝, 3撤单已经提交, 4 订单已经被接受,5 订单已经被拒绝 6订单已经提交
     */
    private Integer orderSubmitStatusType;

    /**
     * XTP系统订单ID
     */
    private String orderXtpId;

    /**
     * 开平标志 1平,2平今,3平昨,4强平,5强减,6初始值或未知值开平标识，现货适用,7,本地强平,8开,9未知的开平标识类型
     */
    private Integer positionEffectType;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 价格类型 1全部成交或撤销,市价单-深, 2即时成交剩余转撤销，市价单-深,3最优5档即时成交剩余转撤销，市价单-沪深,4最优五档即时成交剩余转限价，市价单-沪,                                                  5 本方最优，市价单-深,6限价单-沪深（除普通股票业务外，其余业务均使用此种类型）,7期权限价申报FOK, 8 对方最优剩余转限价，市价单-深,9未知或者无效价格类型
     */
    private Integer priceType;

    /**
     * 剩余数量，当撤单成功时，表示撤单数量
     */
    private Long qtyLeft;

    /**
     * 今成交数量，为此订单累计成交数量
     */
    private Long qtyTraded;

    /**
     * 数量，此订单的报单数量
     */
    private Long quantity;

    /**
     * 此消息响应函数对应的请求ID
     */
    private Long requestId;

    /**
     * 买卖方向类型 1 买（新股申购、ETF买等）,2买平.3买开,4合并,5 申购,6 赎回 7卖（逆回购）,8卖平,9卖开 ,10拆分 ,11未知或者无效买卖方向
     */
    private Integer sideType;

    /**
     * 合约代码
     */
    private String ticker;

    /**
     * 成交金额，为此订单的成交总金额
     */
    private BigDecimal tradeAmount;

    /**
     * 报单类型
     */
    private String txtpOrderTypeType;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;


}