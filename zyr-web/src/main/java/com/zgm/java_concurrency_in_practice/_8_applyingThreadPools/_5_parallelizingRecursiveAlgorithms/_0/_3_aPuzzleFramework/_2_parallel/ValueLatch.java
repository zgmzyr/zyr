/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._2_parallel;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ValueLatch.java $Date: May 24, 2013 3:29:55 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class ValueLatch<T> {
//	@GuardedBy("this")
	private T value = null;
	private final CountDownLatch done = new CountDownLatch(1);

	public boolean isSet() {
		return (done.getCount() == 0);
	}

	public synchronized void setValue(T newValue) {
		if (!isSet()) {
			value = newValue;
			done.countDown();
		}
	}

	public T getValue() throws InterruptedException {
		done.await();
		synchronized (this) {
			return value;
		}
	}
}
