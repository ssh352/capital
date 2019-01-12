package com.bazinga.capital.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈撤单判断池〉<p>
 *
 * @author
 * @date 2019-01-12
 */
@lombok.Data
@lombok.ToString
public class CheckCancelOrderPool implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
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
     * xtp 订单号
     *
     * @最大长度   30
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_order_xtp_id
     */
    private String orderXtpId;

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