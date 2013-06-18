/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._4_testingResourceManagement;

import com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._0.BoundedBuffer;

import static org.junit.Assert.*;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TestLeak.java $Date: May 30, 2013 10:35:23 AM -0400 2013
 * @since 1.0
 * 
 */
public class LeakTest {
	class Big { double[] data = new double[100000]; }

	private static final int CAPACITY = 1000;
	private static final int THRESHOLD = 100000; //TODO

	void testLeak() throws InterruptedException {
	     BoundedBuffer<Big> bb = new BoundedBuffer<Big>(CAPACITY);
	     int heapSize1 =  0 /* snapshot heap */ ; //TODO
	     for (int i = 0; i < CAPACITY; i++)
	         bb.put(new Big());
	     for (int i = 0; i < CAPACITY; i++)
	         bb.take();
	     int heapSize2 =  0 /* snapshot heap */ ;
	     assertTrue(Math.abs(heapSize1 - heapSize2) < THRESHOLD);
	}
}
