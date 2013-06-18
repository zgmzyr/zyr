/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._2_hardwareSupportForConcurrency._1_compareAndSwap;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SimulatedCAS.java $Date: Jun 17, 2013 9:39:40 AM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class SimulatedCAS {
	// @GuardedBy("this")
	private int value;

	public synchronized int get() {
		return value;
	}

	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		if (oldValue == expectedValue) {
			value = newValue;
		}
		
		return oldValue;
	}

	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return (expectedValue == compareAndSwap(expectedValue, newValue));
	}
}
