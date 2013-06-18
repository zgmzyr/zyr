/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._1_lock_orderingDeadlocks;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LeftRightDeadlock.java $Date: May 27, 2013 1:55:16 PM -0400 2013
 * @since 1.0
 * 
 */
public class LeftRightDeadlock {
	private final Object left = new Object();
	private final Object right = new Object();

	public void leftRight() {
		synchronized (left) {
			synchronized (right) {
				doSomething();
			}
		}
	}

	private void doSomething() {
		// TODO

	}

	public void rightLeft() {
		synchronized (right) {
			synchronized (left) {
				doSomethingElse();
			}
		}
	}

	private void doSomethingElse() {
		// TODO

	}
	
	public static void main(String[] args) {
		final LeftRightDeadlock lrd = new LeftRightDeadlock();
		
		Thread thread1 = new Thread() {

			@Override
			public void run() {
				lrd.leftRight();
			}
			
		};
		
		Thread thread2 = new Thread() {

			@Override
			public void run() {
				lrd.rightLeft();
			}
		};
		
		thread1.start();
		thread2.start();
	}
}
