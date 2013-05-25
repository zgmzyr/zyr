/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._120;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SafeStopThread.java $Date: 2012-5-13 上午11:55:38 -0400 2012
 * @since 1.0
 * 
 */
public class SafeStopThread2 extends Thread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t = new SafeStopThread2();
		t.start();
		
		Thread.sleep(1000);
		
		t.interrupt(); //不会使线程停止，只是修改中断标志而已
		
	}

	@Override
	public void run() {
		//while(true) {  //即使调用t.interrupt();也不会停止
		while (!super.isInterrupted()) {
			System.out.println("线程执行了");
		}
	}

}
