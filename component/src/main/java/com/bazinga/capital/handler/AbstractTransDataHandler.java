package com.bazinga.capital.handler;

import com.bazinga.capital.util.ThreadPoolUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutorService;

/**
 * @author yunshan
 */
public abstract class AbstractTransDataHandler<T> implements InitializingBean {

    protected ExecutorService executorService;

    /**
     * 将响应信息持久化
     * @param response api 响应信息
     */
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
