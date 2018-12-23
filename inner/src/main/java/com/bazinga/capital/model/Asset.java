package com.bazinga.capital.model;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈资产〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.ToString
public class Asset implements Serializable {

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
     * 账户类型 信用账户 1 衍生品账户 2 普通账户 3 未知账户类型 4
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer accountType;

    /**
     * 当前余额
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal banlance;

    /**
     * 可用资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal buyingPower;

    /**
     * 资金资产
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal captialAsset;

    /**
     * 当天出入金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal depositWithdraw;

    /**
     * 强锁资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal forceFreezeAmount;

    /**
     * 行权冻结资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal frozenExecCash;

    /**
     * 行权费用
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal frozenExecFee;

    /**
     * 冻结的保证金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal frozenMargin;

    /**
     * 累计买入成交证券占用资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal fundBuyAmount;

    /**
     * 累计买入成交交易费用
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal fundBuyFee;

    /**
     * 累计卖出成交证券所得资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal fundSellAmount;

    /**
     * 累计卖出成交交易费用
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal fundSellFee;

    /**
     * 此消息响应函数是否为request_id这条请求所对应的最后一个响应，当为最后一个的时候为true，如果为false，表示还有其他后续消息响应
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer lastResp;

    /**
     * 昨日余额
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal origBanlance;

    /**
     * 垫付资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal payLater;

    /**
     * 预垫付资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal preadvaPay;

    /**
     * 可取资金
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal preferredAmount;

    /**
     * 此消息响应函数对应的请求ID
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long requestId;

    /**
     * 证券资产
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal securityAsset;

    /**
     * 总资产(=可用资金 + 证券资产（目前为0）+ 预扣的资金)
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal totalAsset;

    /**
     * 当日交易资金轧差
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal tradeNetting;

    /**
     * 保留字段
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long unknown;

    /**
     * XTP系统预扣的资金（包括购买卖股票时预扣的交易资金+预扣手续费）
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private BigDecimal withholdingAmount;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;


}