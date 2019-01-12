package com.bazinga.capital.constant;

/**
 * @author yunshan
 * @date 2019/1/12
 */
public class CommonStatusConstant {

    /**
     * 禁用下单 0001
     */
    public static final int DISABLE_INSERT = 1 << 0;

    /**
     * 需要禁用撤单 0010
     */
    public static final int DISABLE_CANCEL= 1 << 1;

    /**
     * 禁用下单人工操作 0001
     */
    public static final int DISABLE_INSERT_MANUAL_OPERATE = 1 << 0;

    /**
     * 禁用撤单人工操作 0010
     */
    public static final int DISABLE_CANCEL_MANUAL_OPERATE= 1 << 1;

}
