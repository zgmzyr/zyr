/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._123;


/**
 * <p>
 * 	volatile 只能保证线程能够获得最新值 ，不能保证数据是同步的
 * </p>
 * 
 * @author 周光明 Exp
 * @version $FileName: VolatileCannotEnsureDataSynchronization.java $Date:
 *          2012-5-13 下午9:36:05 -0400 2012
 * @since 1.0
 * 
 */
public class VolatileCannotEnsureDataSynchronization implements Runnable {

	private volatile int count = 0;

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Math.hypot(Math.pow(92456789, i), Math.cos(i));
		}

		count++;
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		int value = 1000;
		int loops = 0;
		
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		
		while (loops++ < value) {
			VolatileCannotEnsureDataSynchronization vceds = new VolatileCannotEnsureDataSynchronization();
			for (int i = 0; i < value; i++) {
				new Thread(vceds).start();
			}
			
			do {
				Thread.sleep(15);
			} while (tg.activeCount() != 1);
			
			if (vceds.getCount() != value) {
				System.out.println("循环到第" + loops + "次， 出现线程不安定情况");
				System.out.println("此时，count = " + vceds.getCount());
				
				System.exit(0);
				
			}
		}
		
	}
}
