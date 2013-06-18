/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock;

/**
 *  不要这么做:有可能发生死锁
 * 
 * @author 周光明 Exp
 * @version $FileName: TransferMoney.java $Date: May 27, 2013 2:22:34 PM -0400 2013
 * @since 1.0
 * 
 */
public class TransferMoney {
	//有可能发生死锁
	public void transferMoney(Account fromAccount, Account toAccount, DollarAmount amount)
			throws InsufficientFundsException {
		synchronized (fromAccount) {
			synchronized (toAccount) {
				if (fromAccount.getBalance().compareTo(amount) < 0)
					throw new InsufficientFundsException();
				else {
					fromAccount.debit(amount);
					toAccount.credit(amount);
				}
			}
		}
	}

}
