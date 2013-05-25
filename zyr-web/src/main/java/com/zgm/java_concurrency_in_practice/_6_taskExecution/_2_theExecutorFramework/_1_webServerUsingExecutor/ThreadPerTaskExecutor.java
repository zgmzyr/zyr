/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._6_taskExecution._2_theExecutorFramework._1_webServerUsingExecutor;

import java.util.concurrent.Executor;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ThreadPerTaskExecutor.java $Date: May 17, 2013 2:26:11 PM -0400 2013
 * @since 1.0
 * 
 */
public class ThreadPerTaskExecutor implements Executor {
    public void execute(Runnable r) {
        new Thread(r).start();
    };
}

