/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._127;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LockAndSynchronizedAreNotSame.java $Date: 2012-5-15
 *          下午9:04:39 -0400 2012
 * @since 1.0
 * 
 */
public class LockAndSynchronizedAreNotSame2 {

	/**
	 * @param args
	
	 */
	public static void main(String[] args) {
		final Lock lock = new ReentrantLock();
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						lock.lock();
						Thread.sleep(2000);
						
						System.out.println(Thread.currentThread().getName());
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
					
				}
			}).start();
		}

	}


}
