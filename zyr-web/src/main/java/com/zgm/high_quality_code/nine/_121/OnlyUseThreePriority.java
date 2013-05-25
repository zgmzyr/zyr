/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._121;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: OnlyUseThreePriority.java $Date: 2012-5-13 下午4:37:59 -0400 2012
 * @since 1.0
 * 
 */
public class OnlyUseThreePriority implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			Math.hypot(Math.pow(924526789, i), Math.cos(i));
		}
		
		System.out.println("Priority : " + Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
//			new OnlyUseThreePriority().start(i % 10 + 1);
			if (i % 2 == 0) {
				new OnlyUseThreePriority().start(Thread.MAX_PRIORITY);
			} else {
//				new OnlyUseThreePriority().start(Thread.MIN_PRIORITY);
				new OnlyUseThreePriority().start(Thread.NORM_PRIORITY);
			}
		}
	}

	private void start(int priority) {
		Thread t = new Thread(this);
		t.setPriority(priority);
		t.start();
	}
}
