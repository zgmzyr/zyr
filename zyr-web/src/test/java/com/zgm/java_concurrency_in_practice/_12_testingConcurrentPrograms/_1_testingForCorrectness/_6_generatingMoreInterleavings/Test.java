/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._6_generatingMoreInterleavings;

import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.Account;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Jun 6, 2013 2:31:15 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	public synchronized void transferCredits(Account from, Account to, int amount) {
		from.setBalance(from.getBalance() - amount);
		if (random.nextInt(1000) > THRESHOLD)
			Thread.yield();
		to.setBalance(to.getBalance() + amount);
	}

}
