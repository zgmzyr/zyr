/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.thinking_in_java.thread._21_2_1;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LiftOff.java $Date: 2012-4-11 下午9:36:54 -0400 2012
 * @since 1.0
 * 
 */
public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff() {}
	
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "). ";
	}
	
	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(this.status());
			Thread.yield();
		}
	}

}
