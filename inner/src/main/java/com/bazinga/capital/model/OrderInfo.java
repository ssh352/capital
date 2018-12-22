package com.bazinga.capital.model;

import java.util.Date;
import java.util.Date;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈订单信息〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.ToString
public class OrderInfo implements Serializable {

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
     * 业务类型 普通股票业务 1 新股申购业务 2 回购业务 3 
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer businessType;

    /**
     * 撤销时间
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Date cancelTime;

    /**
     * 委托时间
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Date insertTime;

    /**
     * 初始化值或者未知 0 上海A股 1 深圳A股 2 未知交易市场类型 3
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer marketType;

    /**
     * 报单操作引用，用户自定义
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer orderCancelClientId;

    /**
     * 撤单在XTP系统中的id，在XTP系统中唯一
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer orderCancelXtpId;

    /**
     * 报单引用，用户自定义
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer orderClientId;

    /**
     * 本地报单编号 OMS生成的单号，不等同于order_xtp_id，为服务器传到报盘的单号
     *
     * @最大长度   30
     * @允许为空   YES
     * @是否索引   NO
     */
    private String orderLocalId;

    /**
     * 报单状态类型 0 全部成交, 1 已撤单, 2 初始化, 3 未成交, 4部分撤单,5 部分成交,6 已拒绝, 7 未知订单状态 
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer orderStatusType;

    /**
     * 报单提交状态 1 撤单已经被接受,2撤单已经被拒绝, 3撤单已经提交, 4 订单已经被接受,5 订单已经被拒绝 6订单已经提交
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer orderSubmitStatusType;

    /**
     * XTP系统订单ID
     *
     * @最大长度   50
     * @允许为空   YES
     * @是否索引   NO
     */
    private String orderXtpId;

    /**
     * 开平标志 1平,2平今,3平昨,4强平,5强减,6初始值或未知值开平标识，现货适用,7,本地强平,8开,9未知的开平标识类型
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer positionEffectType;

    /**
     * 价格
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal price;

    /**
     * 价格类型 1全部成交或撤销,市价单-深, 2即时成交剩余转撤销，市价单-深,3最优5档即时成交剩余转撤销，市价单-沪深,4最优五档即时成交剩余转限价，市价单-沪,                                                  5 本方最优，市价单-深,6限价单-沪深（除普通股票业务外，其余业务均使用此种类型）,7期权限价申报FOK, 8 对方最优剩余转限价，市价单-深,9未知或者无效价格类型
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer priceType;

    /**
     * 剩余数量，当撤单成功时，表示撤单数量
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long qtyLeft;

    /**
     * 今成交数量，为此订单累计成交数量
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long qtyTraded;

    /**
     * 数量，此订单的报单数量
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long quantity;

    /**
     * 此消息响应函数对应的请求ID
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long requestId;

    /**
     * 买卖方向类型 1 买（新股申购、ETF买等）,2买平.3买开,4合并,5 申购,6 赎回 7卖（逆回购）,8卖平,9卖开 ,10拆分 ,11未知或者无效买卖方向
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer sideType;

    /**
     * 合约代码
     *
     * @最大长度   20
     * @允许为空   YES
     * @是否索引   NO
     */
    private String ticker;

    /**
     * 成交金额，为此订单的成交总金额
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal tradeAmount;

    /**
     * 报单类型
     *
     * @最大长度   20
     * @允许为空   YES
     * @是否索引   NO
     */
    private String txtpOrderTypeType;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;


}