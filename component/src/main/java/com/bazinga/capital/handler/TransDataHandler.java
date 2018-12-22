package com.bazinga.capital.handler;

import com.bazinga.capital.util.ThreadPoolUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutorService;

/**
 * @author yunshan
 */
public abstract class TransDataHandler<T> implements InitializingBean {

    protected ExecutorService executorService;

    public abstract void transDataToPersist(T response);

    @Override
    public void afterPropertiesSet() throws Exception {
        TransDataHandlerFactory.handlerMap.put(handlerMapKey(), this);
        executorService = ThreadPoolUtils.create(8, 30, 2000, handlerMapKey());
    }

    /**
     * 处理类的 key
     *
     * @return 返回 key
     */
    abstract String handlerMapKey();
}
