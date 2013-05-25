/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._3_configuringThreadPoolExecutor._3_saturationPolicies._2;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BoundedExecutor.java $Date: May 24, 2013 1:55:33 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class BoundedExecutor {
	// Executor使用无界队列
	private final Executor exec;
	private final Semaphore semaphore;

	public BoundedExecutor(Executor exec, int bound) {
		this.exec = exec;
		this.semaphore = new Semaphore(bound);
	}

	public void submitTask(final Runnable command) throws InterruptedException {
		semaphore.acquire();

		try {
			exec.execute(new Runnable() {
				public void run() {
					try {
						command.run();
					} finally {
						semaphore.release();
					}
				}
			});
		} catch (RejectedExecutionException e) {
			semaphore.release();
		}
	}
}
