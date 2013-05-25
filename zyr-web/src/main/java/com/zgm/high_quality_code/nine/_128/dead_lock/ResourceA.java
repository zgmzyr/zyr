/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._128.dead_lock;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ResourceA.java $Date: 2012-6-3 上午9:06:03 -0400 2012
 * @since 1.0
 * 
 */
public class ResourceA {

	public synchronized void methodA1(ResourceB resourceB) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " 进入 ResourceA.methodA1()方法");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " 试图访问ResourcB.methodB2()方法");
		resourceB.methodB2();
	}
	
	public synchronized void methodA2() {
		System.out.println("进入 ResourceA.methodA2() 方法");
	}
}
