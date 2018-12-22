package com.bazinga.capital.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 可命名的线程工厂<p>
 * @author yunshan
 * @date 2018/12/22
 */
public class NamedThreadFactory implements ThreadFactory {

    private final AtomicLong threadIndex = new AtomicLong(0);
    private final String threadNamePrefix;


    public NamedThreadFactory(final String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, threadNamePrefix + this.threadIndex.incrementAndGet());

    }
}
