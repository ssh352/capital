package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈撤单日志 查询参数〉<p>
 *
 * @author
 * @date 2019-01-12
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class CancelOrderLogQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    private String ticker;

    /**
     * 股票名称
     */
    private String tickerName;

    /**
     * 订单号
     */
    private String orderXtpId;

    /**
     * 状态 1 成功  2 失败  0 初始化
     */
    private Integer status;

    /**
     * 重试次数
     */
    private Integer retryCount;

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