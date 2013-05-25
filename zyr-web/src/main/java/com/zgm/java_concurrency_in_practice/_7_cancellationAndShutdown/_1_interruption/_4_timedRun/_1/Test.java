/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._4_timedRun._1;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 21, 2013 9:54:32 AM -0400 2013
 * @since 1.0
 * 
 */

// TODO 不要这么做
public class Test {
	// private static final ScheduledExecutorService cancelExec = ...;
	private static final ScheduledExecutorService cancelExec = null; //TODO

	public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
		final Thread taskThread = Thread.currentThread();
		cancelExec.schedule(new Runnable() {
			public void run() {
				taskThread.interrupt();
			}
		}, timeout, unit);
		
		r.run();
	}

}
