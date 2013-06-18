/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._0;

import java.util.concurrent.Semaphore;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BoundedBuffer.java $Date: May 28, 2013 3:23:50 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class BoundedBuffer<E> {
	private final Semaphore availableItems, availableSpaces;
	// @GuardedBy("this")
	private final E[] items;
	// @GuardedBy("this")
	private int putPosition = 0, takePosition = 0;

	public BoundedBuffer(int capacity) {
		availableItems = new Semaphore(0);
		availableSpaces = new Semaphore(capacity);
		items = (E[]) new Object[capacity]; //TODO
	}

	public boolean isEmpty() {
		return availableItems.availablePermits() == 0;
	}

	public boolean isFull() {
		return availableSpaces.availablePermits() == 0;
	}

	public void put(E x) throws InterruptedException {
		availableSpaces.acquire();
		doInsert(x);
		availableItems.release();
	}

	public E take() throws InterruptedException {
		availableItems.acquire();
		E item = doExtract();
		availableSpaces.release();
		return item;
	}

	private synchronized void doInsert(E x) {
		int i = putPosition;
		items[i] = x;
		putPosition = (++i == items.length) ? 0 : i;
	}

	private synchronized E doExtract() {
		int i = takePosition;
		E x = items[i];
		items[i] = null;
		takePosition = (++i == items.length) ? 0 : i;
		return x;
	}
}
