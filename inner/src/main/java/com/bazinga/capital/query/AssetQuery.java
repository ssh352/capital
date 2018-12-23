package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈资产 查询参数〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class AssetQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户类型 信用账户 1 衍生品账户 2 普通账户 3 未知账户类型 4
     */
    private Integer accountType;

    /**
     * 当前余额
     */
    private BigDecimal banlance;

    /**
     * 可用资金
     */
    private BigDecimal buyingPower;

    /**
     * 资金资产
     */
    private BigDecimal captialAsset;

    /**
     * 当天出入金
     */
    private BigDecimal depositWithdraw;

    /**
     * 强锁资金
     */
    private BigDecimal forceFreezeAmount;

    /**
     * 行权冻结资金
     */
    private BigDecimal frozenExecCash;

    /**
     * 行权费用
     */
    private BigDecimal frozenExecFee;

    /**
     * 冻结的保证金
     */
    private BigDecimal frozenMargin;

    /**
     * 累计买入成交证券占用资金
     */
    private BigDecimal fundBuyAmount;

    /**
     * 累计买入成交交易费用
     */
    private BigDecimal fundBuyFee;

    /**
     * 累计卖出成交证券所得资金
     */
    private BigDecimal fundSellAmount;

    /**
     * 累计卖出成交交易费用
     */
    private BigDecimal fundSellFee;

    /**
     * 此消息响应函数是否为request_id这条请求所对应的最后一个响应，当为最后一个的时候为true，如果为false，表示还有其他后续消息响应
     */
    private Integer lastResp;

    /**
     * 昨日余额
     */
    private BigDecimal origBanlance;

    /**
     * 垫付资金
     */
    private BigDecimal payLater;

    /**
     * 预垫付资金
     */
    private BigDecimal preadvaPay;

    /**
     * 可取资金
     */
    private BigDecimal preferredAmount;

    /**
     * 此消息响应函数对应的请求ID
     */
    private Long requestId;

    /**
     * 证券资产
     */
    private BigDecimal securityAsset;

    /**
     * 总资产(=可用资金 + 证券资产（目前为0）+ 预扣的资金)
     */
    private BigDecimal totalAsset;

    /**
     * 当日交易资金轧差
     */
    private BigDecimal tradeNetting;

    /**
     * 保留字段
     */
    private Long unknown;

    /**
     * XTP系统预扣的资金（包括购买卖股票时预扣的交易资金+预扣手续费）
     */
    private BigDecimal withholdingAmount;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;


}