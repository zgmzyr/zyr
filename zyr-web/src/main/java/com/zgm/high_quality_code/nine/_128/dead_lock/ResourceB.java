/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._128.dead_lock;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ResourceB.java $Date: 2012-6-3 上午9:08:34 -0400 2012
 * @since 1.0
 * 
 */
public class ResourceB {

	public synchronized void methodB1(ResourceA resourceA) {
		String name = Thread.currentThread().getName();
		System.out.println(name + " 进入 ResourceB.methodB1()方法");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " 试图访问ResourcA.methodA2()方法");
		resourceA.methodA2();
	}
	
	public synchronized void methodB2() {
		System.out.println("进入 ResourceB.methodB2() 方法");
	}
	
	public static void main(String[] args) {
		final ResourceA resourceA = new ResourceA();
		final ResourceB resourceB = new ResourceB();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				resourceA.methodA1(resourceB);
			}
			
		}, "线程A").start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				resourceB.methodB1(resourceA);
			}
			
		}, "线程B").start();
	}

}
