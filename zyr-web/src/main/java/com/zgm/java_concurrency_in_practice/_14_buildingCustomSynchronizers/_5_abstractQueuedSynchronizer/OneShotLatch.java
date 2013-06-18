/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._5_abstractQueuedSynchronizer;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: OneShotLatch.java $Date: Jun 14, 2013 2:36:05 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class OneShotLatch {
	private final Sync sync = new Sync();

	public void signal() {
		sync.releaseShared(0);
	}

	public void await() throws InterruptedException {
		sync.acquireSharedInterruptibly(0);
	}

	private class Sync extends AbstractQueuedSynchronizer {
		@Override
		protected int tryAcquireShared(int ignored) {
			// Succeed if latch is open (state == 1), else fail
			return (getState() == 1) ? 1 : -1;
		}

		@Override
		protected boolean tryReleaseShared(int ignored) {
			setState(1); // Latch is now open
			return true; // Other threads may now be able to acquire

		}
	}
}
