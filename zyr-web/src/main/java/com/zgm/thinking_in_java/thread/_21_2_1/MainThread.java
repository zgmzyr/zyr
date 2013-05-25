/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.thinking_in_java.thread._21_2_1;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: MainThread.java $Date: 2012-4-11 下午9:49:22 -0400 2012
 * @since 1.0
 * 
 */
public class MainThread {
	public static void main(String[] args) {
		LiftOff liftOff = new LiftOff();
		liftOff.run();
	}
}
