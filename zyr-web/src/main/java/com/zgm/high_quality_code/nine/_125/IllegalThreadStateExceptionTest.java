/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._125;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: IllegalThreadStateExceptionTest.java $Date: 2012-5-14 下午9:50:18 -0400 2012
 * @since 1.0
 * 
 */
public class IllegalThreadStateExceptionTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程正在运行........");
			}
		});
		
		t.start();
		
		while (!t.getState().equals(Thread.State.TERMINATED)) {
			TimeUnit.MILLISECONDS.sleep(10);
		}
		
		t.start(); //t 线程已经为终止状态，再调用会throw 异常

	}

}
