/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._3_configuringThreadPoolExecutor._3_saturationPolicies._1;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 24, 2013 1:49:52 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test {

	private static final int N_THREADS = 5;
	private static final int CAPACITY = 10;

	public void test() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(N_THREADS, N_THREADS, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(CAPACITY));
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

	}

}
