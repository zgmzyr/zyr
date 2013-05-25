/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._5_cancellationViaFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 21, 2013 11:00:13 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	private static ExecutorService taskExec = Executors.newCachedThreadPool();

	public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
		Future<?> task = taskExec.submit(r);
		try {
			task.get(timeout, unit);
		} catch (TimeoutException e) {
			// task will be cancelled below
		} catch (ExecutionException e) {
			// exception thrown in task; rethrow
			throw launderThrowable(e.getCause());
		} finally {
			// Harmless if task already completed
			//另：如果Future.get抛出了TimeoutException或者InterruptedException,可以取消不需要结果的任务
			task.cancel(true); // interrupt if running
		}
	}

	/**
	 * If the Throwable is an Error, throw it; if it is a RuntimeException return it, otherwise throw
	 * IllegalStateException
	 */
	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException) t;
		else if (t instanceof Error)
			throw (Error) t;
		else
			throw new IllegalStateException("Not unchecked", t);
	}
}
