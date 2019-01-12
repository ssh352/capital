package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈禁止操作池 查询参数〉<p>
 *
 * @author
 * @date 2019-01-12
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class DisableOperateTicketPoolQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    private String ticker;

    /**
     * 
     */
    private String tickerName;

    /**
     * 日期显示 格式 yyyy-MM-dd
     */
    private String day;

    /**
     * 0 系统操作 1 人工操作
     */
    private Integer operateStatus;

    /**
     * 2 进制标识 11 禁止下单 禁止撤单, 10 禁止下单,01 禁止撤单 00 都不禁止
     */
    private Integer businessStatus;

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