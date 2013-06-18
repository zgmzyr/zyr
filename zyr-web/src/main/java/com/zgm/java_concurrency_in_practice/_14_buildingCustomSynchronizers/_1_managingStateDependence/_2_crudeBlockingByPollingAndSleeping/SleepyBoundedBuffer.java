/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence._2_crudeBlockingByPollingAndSleeping;

import com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence.BaseBoundedBuffer;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SleepyBoundedBuffer.java $Date: Jun 13, 2013 10:25:29 AM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
	private static final long SLEEP_GRANULARITY = 10000;

	public SleepyBoundedBuffer(int size) {
		super(size);
	}

	public void put(V v) throws InterruptedException {
		while (true) {
			
			synchronized (this) {
				if (!isFull()) {
					doPut(v);
					return;
				}
			}
			
			Thread.sleep(SLEEP_GRANULARITY);
		}
	}

	public V take() throws InterruptedException {
		while (true) {
			
			synchronized (this) {
				if (!isEmpty())
					return doTake();
			}
			
			Thread.sleep(SLEEP_GRANULARITY);
		}
	}
}
