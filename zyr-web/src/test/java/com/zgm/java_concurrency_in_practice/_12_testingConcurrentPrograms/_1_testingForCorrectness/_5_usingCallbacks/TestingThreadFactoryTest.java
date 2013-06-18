/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._5_usingCallbacks;

import java.util.concurrent.ExecutorService;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.Executors;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TestingThreadFactoryTest.java $Date: May 30, 2013 10:55:44 AM -0400 2013
 * @since 1.0
 * 
 */
public class TestingThreadFactoryTest {
	private TestingThreadFactory threadFactory = new TestingThreadFactory();

	public void testPoolExpansion() throws InterruptedException {
		int MAX_SIZE = 10;
		ExecutorService exec = Executors.newFixedThreadPool(MAX_SIZE);

		for (int i = 0; i < 10 * MAX_SIZE; i++)
			exec.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(Long.MAX_VALUE);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			});
		for (int i = 0; i < 20 && threadFactory.numCreated.get() < MAX_SIZE; i++)
			Thread.sleep(100);
		assertEquals(threadFactory.numCreated.get(), MAX_SIZE);
		exec.shutdownNow();
	}
}
