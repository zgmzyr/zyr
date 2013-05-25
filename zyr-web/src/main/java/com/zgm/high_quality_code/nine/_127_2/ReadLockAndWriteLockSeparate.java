/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._127_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ReadLockAndWriteLockSeparate.java $Date: 2012-5-24 下午10:10:39 -0400 2012
 * @since 1.0
 * 
 */
public class ReadLockAndWriteLockSeparate {

	private final ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	private final Lock readLock = rrwl.readLock();
	private final Lock writeLock = rrwl.writeLock();
//	private volatile int count = 0;
	private int count = 0;
	
	public void read() {
		try {
			readLock.lock();
			System.out.println("count = " + count);
			Thread.sleep(1000);
			System.out.println("正在读... count = " + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}
	
	public void write() {
		try {
			writeLock.lock();
			System.out.println("自增之前 : count = " + count);
			
			count++; 
			
			Thread.sleep(1000);
			System.out.println("正在写......... count = " + count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ReadLockAndWriteLockSeparate rlawls = new ReadLockAndWriteLockSeparate();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Runnable() {

				@Override
				public void run() {
					rlawls.read();
				}
			});
			
			executorService.submit(new Runnable() {

				@Override
				public void run() {
					rlawls.write();
				}
			});
			
		}
	}

}
