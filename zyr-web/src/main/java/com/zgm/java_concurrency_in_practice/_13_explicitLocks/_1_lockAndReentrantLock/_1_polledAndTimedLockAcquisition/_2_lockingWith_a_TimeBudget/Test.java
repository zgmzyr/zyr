/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._13_explicitLocks._1_lockAndReentrantLock._1_polledAndTimedLockAcquisition._2_lockingWith_a_TimeBudget;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Jun 8, 2013 3:24:19 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	private static final TimeUnit NANOSECONDS = TimeUnit.NANOSECONDS;
	private final Lock lock = new ReentrantLock();

	public boolean trySendOnSharedLine(String message, long timeout, TimeUnit unit) throws InterruptedException {
		long nanosToLock = unit.toNanos(timeout) - estimatedNanosToSend(message);
		if (!lock.tryLock(nanosToLock, NANOSECONDS)) {
			return false;
		}
		
		try {
			return sendOnSharedLine(message);
		} finally {
			lock.unlock();
		}
	}

	private boolean sendOnSharedLine(String message) {
		// TODO
		return false;
	}

	private long estimatedNanosToSend(String message) {
		// TODO
		return 0;
	}
}
