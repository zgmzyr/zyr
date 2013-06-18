/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._13_explicitLocks._1_lockAndReentrantLock._1_polledAndTimedLockAcquisition._1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.DollarAmount;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Account.java $Date: Jun 8, 2013 3:09:20 PM -0400 2013
 * @since 1.0
 * 
 */
public class Account {

	public final Lock lock = new ReentrantLock();

	public DollarAmount getBalance() {
		// TODO
		return new DollarAmount(0);
	}

	public void debit(DollarAmount amount) {
		// TODO

	}

	public void credit(DollarAmount amount) {
		// TODO

	}
}
