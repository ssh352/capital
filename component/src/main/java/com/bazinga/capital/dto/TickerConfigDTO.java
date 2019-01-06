package com.bazinga.capital.dto;

import lombok.Data;

/**
 * @author yunshan
 * @date 2019/1/6
 */
@Data
public class TickerConfigDTO {

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
     * 流通量z
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long circulateZ;


}
