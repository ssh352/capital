package com.bazinga.capital.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈股票类型配置信息〉<p>
 *
 * @author
 * @date 2019-01-06
 */
@lombok.Data
@lombok.ToString
public class CirculateTypeConfig implements Serializable {

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
     * 类型  0 一亿一下  1 1亿到3亿   2 3亿以上
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer circulateType;

    /**
     * 百分比 如果是5% 则值为5
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer percent;

    /**
     * 能下单的最小股数
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long minInsertQuantity;

    /**
     * 查询行情与流通信息对比的延时时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer checkCirculateDelay;

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