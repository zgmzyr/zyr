/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._7_encapsulatingNonstandardCancellationWithNewtaskfor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CancellingExecutor.java $Date: May 21, 2013 2:23:55 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class CancellingExecutor extends ThreadPoolExecutor {
	
	public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	// ...
	protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
		if (callable instanceof CancellableTask)
			return ((CancellableTask<T>) callable).newTask();
		else
			return super.newTaskFor(callable);
	}
}
