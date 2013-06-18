/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._3_explicitConditionObjects;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ConditionBoundedBuffer.java $Date: Jun 13, 2013 3:55:04 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class ConditionBoundedBuffer<T> {
	private static final int BUFFER_SIZE = 10;
	protected final Lock lock = new ReentrantLock();
	// CONDITION PREDICATE: notFull (count < items.length)
	private final Condition notFull = lock.newCondition();
	// CONDITION PREDICATE: notEmpty (count > 0)
	private final Condition notEmpty = lock.newCondition();
	// @GuardedBy("lock")
	private final T[] items = (T[]) new Object[BUFFER_SIZE];

	// @GuardedBy("lock")
	private int tail, head, count;

	// BLOCKS-UNTIL: notFull
	public void put(T x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[tail] = x;
			if (++tail == items.length)
				tail = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	// BLOCKS-UNTIL: notEmpty
	public T take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			T x = items[head];
			items[head] = null;
			if (++head == items.length)
				head = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}
