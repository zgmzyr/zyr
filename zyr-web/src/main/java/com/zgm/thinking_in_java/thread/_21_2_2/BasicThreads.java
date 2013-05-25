/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.thinking_in_java.thread._21_2_2;

import com.zgm.thinking_in_java.thread._21_2_1.LiftOff;
import com.zgm.zen.state.example2.Lift;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BasicThreads.java $Date: 2012-4-11 下午9:54:55 -0400 2012
 * @since 1.0
 * 
 */
public class BasicThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("waiting for liftoff");
	}

}
