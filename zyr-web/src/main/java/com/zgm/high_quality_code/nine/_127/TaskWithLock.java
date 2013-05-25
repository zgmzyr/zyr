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
public class TaskWithLock extends Task implements Runnable {

	/**
	 *  将Lock 定义为多线程类的私有属性起不到资源互斥作用，除非将定义为所有线程的共享变量
	 */
	private final Lock lock = new ReentrantLock(); 
	
	@Override
	public void run() {
		try {
			lock.lock();
			doSomething();
		} finally {
			lock.unlock();
		}
	}

}
