/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._4_timedRun._2;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 21, 2013 10:10:20 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	// private static final ScheduledExecutorService cancelExec = ...;
	private static final ScheduledExecutorService cancelExec = null; // TODO

	// TODO 在专门的线程中中断任务，不会忽略RuntimeException
	public static void timedRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
		
		class RethrowableTask implements Runnable {
			private volatile Throwable t;

			public void run() {
				try {
					r.run();
				} catch (Throwable t) {
					this.t = t;
				}
			}

			void rethrow() {
				if (t != null)
					throw launderThrowable(t);
			}

			private RuntimeException launderThrowable(Throwable t2) {
				// TODO
				return null;
			}
		}

		RethrowableTask task = new RethrowableTask();
		final Thread taskThread = new Thread(task);
		taskThread.start();
		cancelExec.schedule(new Runnable() {
			public void run() {
				taskThread.interrupt();
			}
		}, timeout, unit);

		//TODO 依赖join方法，不足：无法知道执行控制是正常是因为线程正常退出而返回还是因为join超时而返回
		taskThread.join(unit.toMillis(timeout));
		task.rethrow();
	}

}
