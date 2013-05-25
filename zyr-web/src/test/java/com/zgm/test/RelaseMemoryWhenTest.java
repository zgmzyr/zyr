/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.test;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: RelaseMemoryWhenTest.java $Date: 2012-12-22 下午9:45:07 -0400 2012
 * @since 1.0
 * 
 */
public class RelaseMemoryWhenTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		test1();
		test2();

	}
	
	public static void test1() {
		for (int index = 0; index < 50000; index++) {
			Object object = new Object();
			
			if (index == 25000) {
				System.out.println("观察GC是否回收object");
			}
		}
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		 
	    System.out.println("系统物理内存总计：" + osmb.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
	 
	    System.out.println("系统物理可用内存总计：" + osmb.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
	}
	

	public static void test2() {
		Object object = null;
		for (int index = 0; index < 50000; index++) {
			 object = new Object();
		}
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		 
	    System.out.println("系统物理内存总计：" + osmb.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
	 
	    System.out.println("系统物理可用内存总计：" + osmb.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
	}
}
