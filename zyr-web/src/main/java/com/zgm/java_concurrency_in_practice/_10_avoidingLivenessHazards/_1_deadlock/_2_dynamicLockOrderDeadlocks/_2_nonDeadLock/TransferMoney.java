/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._2_nonDeadLock;

import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.Account;
import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.DollarAmount;
import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.InsufficientFundsException;

/**
 * 不会发生死锁
 * 
 * @author 周光明 Exp
 * @version $FileName: TransferMoney.java $Date: May 27, 2013 2:22:34 PM -0400 2013
 * @since 1.0
 * 
 */
public class TransferMoney {
	private static final Object tieLock = new Object();

	public void transferMoney(final Account fromAcct, final Account toAcct, final DollarAmount amount)
			throws InsufficientFundsException {
		
		class Helper {
			public void transfer() throws InsufficientFundsException {
				if (fromAcct.getBalance().compareTo(amount) < 0)
					throw new InsufficientFundsException();
				else {
					fromAcct.debit(amount);
					toAcct.credit(amount);
				}
			}
		}
		
		int fromHash = System.identityHashCode(fromAcct);
		int toHash = System.identityHashCode(toAcct);

		if (fromHash < toHash) {
			synchronized (fromAcct) {
				synchronized (toAcct) {
					new Helper().transfer();
				}
			}
		} else if (fromHash > toHash) {
			synchronized (toAcct) {
				synchronized (fromAcct) {
					new Helper().transfer();
				}
			}
		} else {
			synchronized (tieLock) {
				synchronized (fromAcct) {
					synchronized (toAcct) {
						new Helper().transfer();
					}
				}
			}
		}
	}

}
