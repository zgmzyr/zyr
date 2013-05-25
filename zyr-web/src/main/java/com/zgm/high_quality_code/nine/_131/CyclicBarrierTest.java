/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._131;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CyclicBarrierTest.java $Date: 2012-6-14 下午9:57:06 -0400 2012
 * @since 1.0
 * 
 */
public class CyclicBarrierTest {

	static class Worker implements Runnable {
		
		private CyclicBarrier cyclicBarrier;
		
		public Worker(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}
		
		@Override
		public void run() {
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "- 到达汇合 ");
			
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "- 执行结束");
			
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
			@Override
			public void run() {
				System.out.println("隧道已经打通！");
			}
		});

		new Thread(new Worker(cyclicBarrier), "工人1").start();
		new Thread(new Worker(cyclicBarrier), "工人2").start();
	}

}
