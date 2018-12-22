package com.bazinga.capital.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yunshan
 * @date 2018/12/22
 */
public class TransDataHandlerFactory {

    public static Map<String, TransDataHandler> handlerMap = new ConcurrentHashMap<>(64);

    public static TransDataHandler createHandler(String key){
        return handlerMap.get(key);
    }

}
