/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._2_thread_safety._3_locking._2_reentrancy;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LoggingWidget.java $Date: Apr 12, 2013 11:30:03 AM -0400 2013
 * @since 1.0
 * 
 */
public class LoggingWidget extends Widget {

	@Override
	public synchronized void doSomething() {
		System.out.println(toString() + ": calling doSomething");
		
		super.doSomething();
	}
}
