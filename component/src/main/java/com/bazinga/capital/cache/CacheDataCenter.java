package com.bazinga.capital.cache;

import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.model.CirculateTypeConfig;

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

    /**
     * 股票类型配置信息
     */
    public static Map<String, CirculateTypeConfig> CONFIG_MAP = new ConcurrentHashMap<>(8);

    /**
     * 单只股票的业务配置信息
     */
    public static Map<String, TickerConfigDTO> TICKER_CONFIG_MAP= new ConcurrentHashMap<>(4096);

    public static Set<String> TICKER_PERSIST_SET = new HashSet<>();

    /**
     * 禁用下单集合
     */
    public static Set<String> DISABLE_INSERT_ORDER_SET = new HashSet<>();


}
