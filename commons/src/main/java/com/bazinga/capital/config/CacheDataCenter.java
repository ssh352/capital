package com.bazinga.capital.config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yunshan
 * @date 2019/1/4
 */
public class CacheDataCenter {

    public static Map<String, String> tickerPersistMap = new ConcurrentHashMap<>(256);
    public static Set<String> TICKER_PERSIST_SET = new HashSet<>();

    /**
     * 禁用下单集合
     */
    public static Set<String> DISABLE_INSERT_ORDER_SET=new HashSet<>();


}
