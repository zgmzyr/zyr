/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._5_synchronizers._1_latches;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TestHarness.java $Date: May 16, 2013 9:48:58 AM -0400 2013
 * @since 1.0
 * 
 */
public class TestHarness {
	
	public static void main(String[] args) throws InterruptedException {
		TestHarness th = new TestHarness();
		
		Runnable task = new Runnable() {
			private int count = 0;
			
			@Override
			public void run() {
				System.out.println("count = " + count++);
			}
		};
		
		th.timeTasks(3, task);
	}
	
    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) { }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end-start;
    }
}

