/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._3;

import java.util.Random;

import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.Account;
import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.DollarAmount;
import com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._2_dynamicLockOrderDeadlocks._1_deadLock.InsufficientFundsException;

/**
 * 容易发生死锁的示例
 * 
 * @author 周光明 Exp
 * @version $FileName: DemonstrateDeadlock.java $Date: May 27, 2013 2:49:51 PM -0400 2013
 * @since 1.0
 * 
 */
public class DemonstrateDeadlock {
	private static final int NUM_THREADS = 20;
	private static final int NUM_ACCOUNTS = 5;
	private static final int NUM_ITERATIONS = 1000000;

	public static void main(String[] args) {
		final Random rnd = new Random();
		final Account[] accounts = new Account[NUM_ACCOUNTS];

		for (int i = 0; i < accounts.length; i++)
			accounts[i] = new Account();

		class TransferThread extends Thread {
			public void run() {
				for (int i = 0; i < NUM_ITERATIONS; i++) {
					int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
					int toAcct = rnd.nextInt(NUM_ACCOUNTS);
					DollarAmount amount = new DollarAmount(rnd.nextInt(1000));
					try {
						transferMoney(accounts[fromAcct], accounts[toAcct], amount);
					} catch (InsufficientFundsException e) {
						e.printStackTrace();
					}
				}
			}

			// 有可能发生死锁
			private void transferMoney(Account fromAccount, Account toAccount, DollarAmount amount)
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
		
		for (int i = 0; i < NUM_THREADS; i++)
			new TransferThread().start();
	}
}
