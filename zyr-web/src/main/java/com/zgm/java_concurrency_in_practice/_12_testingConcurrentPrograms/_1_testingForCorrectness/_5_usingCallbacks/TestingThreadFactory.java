/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._5_usingCallbacks;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TestingThreadFactory.java $Date: May 30, 2013 10:51:43 AM -0400 2013
 * @since 1.0
 * 
 */
class TestingThreadFactory implements ThreadFactory {
	public final AtomicInteger numCreated = new AtomicInteger();
	private final ThreadFactory factory = Executors.defaultThreadFactory();

	public Thread newThread(Runnable r) {
		numCreated.incrementAndGet();
		return factory.newThread(r);
	}
}
