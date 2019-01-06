package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈股票类型配置信息 查询参数〉<p>
 *
 * @author
 * @date 2019-01-06
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class CirculateTypeConfigQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型  0 一亿一下  1 1亿到3亿   2 3亿以上
     */
    private Integer circulateType;

    /**
     * 百分比 如果是5% 则值为5
     */
    private Integer percent;

    /**
     * 能下单的最小股数
     */
    private Long minInsertQuantity;

    /**
     * 查询行情与流通信息对比的延时时间
     */
    private Integer checkCirculateDelay;

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