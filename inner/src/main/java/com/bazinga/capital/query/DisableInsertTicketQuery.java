package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈DisableInsertTicket 查询参数〉<p>
 *
 * @author
 * @date 2019-01-09
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class DisableInsertTicketQuery extends PagingQuery implements Serializable {

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
    private Integer operateType;

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