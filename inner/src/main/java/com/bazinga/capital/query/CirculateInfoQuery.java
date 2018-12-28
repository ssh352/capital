package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈流通信息 查询参数〉<p>
 *
 * @author
 * @date 2018-12-28
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class CirculateInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ticker编号
     */
    private String ticker;

    /**
     * ticker名称
     */
    private String tickerName;

    /**
     * 总流通量
     */
    private Long circulate;

    /**
     * 流通量z
     */
    private Long circulateZ;

    /**
     * 类型  0 一亿一下  1 1亿到3亿   2 3亿以上
     */
    private Integer circulateType;

    /**
     * 季度 开始
     */
    private Date changeTimeFrom;

    /**
     * 季度 结束
     */
    private Date changeTimeTo;

}