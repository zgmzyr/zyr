/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._13_explicitLocks._1_lockAndReentrantLock._1_polledAndTimedLockAcquisition._1;

import java.util.concurrent.TimeUnit;

import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.DollarAmount;
import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.InsufficientFundsException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TransferMoney.java $Date: Jun 8, 2013 3:06:19 PM -0400 2013
 * @since 1.0
 * 
 */
public class TransferMoney {
	private static final TimeUnit NANOSECONDS = TimeUnit.NANOSECONDS;

	public boolean transferMoney(Account fromAcct, Account toAcct, DollarAmount amount, long timeout, TimeUnit unit)
			throws InsufficientFundsException, InterruptedException {
		long fixedDelay = this.getFixedDelayComponentNanos(timeout, unit);
		long randMod = this.getRandomDelayModulusNanos(timeout, unit);
		long stopTime = System.nanoTime() + unit.toNanos(timeout);

		while (true) {
			if (fromAcct.lock.tryLock()) {
				try {
					if (toAcct.lock.tryLock()) {
						try {
							if (fromAcct.getBalance().compareTo(amount) < 0)
								throw new InsufficientFundsException();
							else {
								fromAcct.debit(amount);
								toAcct.credit(amount);
								return true;
							}
						} finally {
							toAcct.lock.unlock();
						}
					}
				} finally {
					fromAcct.lock.unlock();
				}
			}
			if (System.nanoTime() < stopTime)
				return false;
			NANOSECONDS.sleep(fixedDelay + rnd.nextLong() % randMod);
		}
	}

	private long getRandomDelayModulusNanos(long timeout, TimeUnit unit) {
		// TODO
		return 0;
	}

	private long getFixedDelayComponentNanos(long timeout, TimeUnit unit) {
		// TODO
		return 0;
	}

}
