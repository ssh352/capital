package com.bazinga.capital.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈撤单日志〉<p>
 *
 * @author
 * @date 2019-01-12
 */
@lombok.Data
@lombok.ToString
public class CancelOrderLog implements Serializable {

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
     * @最大长度   10
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticker;

    /**
     * 股票名称
     *
     * @最大长度   30
     * @允许为空   YES
     * @是否索引   NO
     */
    private String tickerName;

    /**
     * 订单号
     *
     * @最大长度   30
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_order_xtp_id
     */
    private String orderXtpId;

    /**
     * 状态 1 成功  2 失败  0 初始化
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer status;

    /**
     * 重试次数
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer retryCount;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
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