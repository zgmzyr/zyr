/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._4_anatomy_of_a_Synchronizer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SemaphoreOnLock.java $Date: Jun 13, 2013 4:05:36 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class SemaphoreOnLock {
	private final Lock lock = new ReentrantLock();
	// CONDITION PREDICATE: permitsAvailable (permits > 0)
	private final Condition permitsAvailable = lock.newCondition();
	// @GuardedBy("lock")
	private int permits;

	SemaphoreOnLock(int initialPermits) {
		lock.lock();
		try {
			permits = initialPermits;
		} finally {
			lock.unlock();
		}
	}

	// BLOCKS-UNTIL: permitsAvailable
	public void acquire() throws InterruptedException {
		lock.lock();
		try {
			while (permits <= 0) {
				permitsAvailable.await();
			}
			
			--permits;
		} finally {
			lock.unlock();
		}
	}

	public void release() {
		lock.lock();
		try {
			++permits;
			permitsAvailable.signal();
		} finally {
			lock.unlock();
		}
	}
}
