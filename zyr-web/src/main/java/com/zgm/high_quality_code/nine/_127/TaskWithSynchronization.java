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
 * @version $FileName: TaskWithLock.java $Date: 2012-5-15 下午8:57:38 -0400 2012
 * @since 1.0
 * 
 */
public class TaskWithSynchronization extends Task implements Runnable {

	
	@Override
	public void run() {
		synchronized ("") {
			doSomething();
		}
	}

}
