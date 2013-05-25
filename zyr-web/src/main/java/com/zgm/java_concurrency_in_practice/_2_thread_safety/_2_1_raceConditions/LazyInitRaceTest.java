/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._2_thread_safety._2_1_raceConditions;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LazyInitRaceTest.java $Date: Apr 11, 2013 9:25:29 AM -0400 2013
 * @since 1.0
 * 
 */
public class LazyInitRaceTest {

	public static void main(String[] args) {
		final LazyInitRace lir = new LazyInitRace();
//		final ExpensiveObject eo ;
				
		Thread thread1 = new Thread() {
			
			@Override
			public void run() {
//				final ExpensiveObject eo = lir.getInstance();
				ExpensiveObject eo = lir.getInstance();
				eo.setAge(31);
				eo.setName("zgm1");
				System.out.println("thread1: " + eo);
			}
		};
				
		Thread thread2 = new Thread() {
			
			@Override
			public void run() {
//				final ExpensiveObject eo = lir.getInstance();
				ExpensiveObject eo = lir.getInstance();
				eo.setAge(32);
				eo.setName("zgm2");
				System.out.println("thread2: " + eo);
			}
		};
		
		thread1.start();
		thread2.start();
	}
}
