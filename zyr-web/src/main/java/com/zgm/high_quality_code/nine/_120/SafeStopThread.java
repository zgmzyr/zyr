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
public class SafeStopThread extends Thread {

	private volatile boolean stop = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TODO

	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("线程执行了");
		}
	}

	public void terminate() {
		stop = true;
	}
}
