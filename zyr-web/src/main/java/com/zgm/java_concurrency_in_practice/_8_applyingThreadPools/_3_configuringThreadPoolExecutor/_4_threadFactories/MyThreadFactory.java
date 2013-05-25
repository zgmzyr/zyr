/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._3_configuringThreadPoolExecutor._4_threadFactories;

import java.util.concurrent.ThreadFactory;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: MyThreadFactory.java $Date: May 24, 2013 2:12:54 PM -0400 2013
 * @since 1.0
 * 
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}



