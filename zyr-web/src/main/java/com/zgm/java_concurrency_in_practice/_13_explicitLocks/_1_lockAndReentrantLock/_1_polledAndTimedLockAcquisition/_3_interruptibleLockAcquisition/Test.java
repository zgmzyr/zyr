/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._13_explicitLocks._1_lockAndReentrantLock._1_polledAndTimedLockAcquisition._3_interruptibleLockAcquisition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Jun 9, 2013 9:47:16 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	private Lock lock = new ReentrantLock();

	public boolean sendOnSharedLine(String message) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			return cancellableSendOnSharedLine(message);
		} finally {
			lock.unlock();
		}
	}

	private boolean cancellableSendOnSharedLine(String message) throws InterruptedException {

		throw new InterruptedException();// TODO
	}

}
