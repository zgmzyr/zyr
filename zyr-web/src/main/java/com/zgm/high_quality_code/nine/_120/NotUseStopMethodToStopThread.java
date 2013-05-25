/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._120;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: NotUseStopMethodToStopThread.java $Date: 2012-5-13 上午10:32:09 -0400 2012
 * @since 1.0
 * 
 */
public class NotUseStopMethodToStopThread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
//		stopMethodCauseLogicalNotIntegrity();
		stopMethodBreakAtomicLogical();
	}

	/**
	 * stop 方法会导致代码逻辑不完整
	 * @throws InterruptedException
	 */
	private static void stopMethodCauseLogicalNotIntegrity()
			throws InterruptedException {
		Thread t = new Thread() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("此处代码不会被执行"); //调用stop方法前，可能还没执行
			}
			
		};
		
		t.start();
		
		Thread.sleep(100);
		
		t.stop();
		
		System.out.println("main方法执行结束");
	}
	
	/**
	 * stop 方法会破坏原子逻辑
	 */
	private static void stopMethodBreakAtomicLogical() {
		Runnable task = new Runnable() {
			
			int a = 0;
			
			@Override
			public void run() {
				synchronized ("") {
					a++;
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					a--;
					
					String threadName = Thread.currentThread().getName();
					System.out.println(threadName + " : a = " + a);
					
				}
				
			}
		};
		
		Thread t = new Thread(task);
		t.start();
		
		for (int i = 0; i < 5; i++) {
			new Thread(task).start();
		}
		
		t.stop();
	}

}
