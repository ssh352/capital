package com.bazinga.capital.model;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈流通信息〉<p>
 *
 * @author
 * @date 2018-12-28
 */
@lombok.Data
@lombok.ToString
public class CirculateInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Integer id;

    /**
     * ticker编号
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticker;

    /**
     * ticker名称
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String tickerName;

    /**
     * 总流通量
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long circulate;

    /**
     * 流通量z
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long circulateZ;

    /**
     * 类型  0 一亿一下  1 1亿到3亿   2 3亿以上
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer circulateType;

    /**
     * 季度
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date changeTime;


}