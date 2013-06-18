/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._2_usingConditionQueues._4_notification;

import com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence.BaseBoundedBuffer;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BoundedBuffer.java $Date: Jun 13, 2013 10:55:36 AM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
	// CONDITION PREDICATE: not-full (!isFull())
	// CONDITION PREDICATE: not-empty (!isEmpty())

	public BoundedBuffer(int size) {
		super(size);
	}

	// BLOCKS-UNTIL: not-full
	public synchronized void put(V v) throws InterruptedException {
		while (isFull()) {
			wait();
		}
		
		boolean wasEmpty = isEmpty();
		doPut(v);
		
		//使用条件通知
		if (wasEmpty) {
			notifyAll();
		}
	}

	// BLOCKS-UNTIL: not-empty
	public synchronized V take() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}

		boolean wasFull = super.isFull();
		V v = doTake();
		
		//使用条件通知
		if (wasFull) {
			notifyAll();
		}

		return v;
	}
}
