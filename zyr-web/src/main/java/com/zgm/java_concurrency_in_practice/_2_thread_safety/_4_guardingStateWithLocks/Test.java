/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._2_thread_safety._4_guardingStateWithLocks;

import java.util.Vector;


/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Apr 12, 2013 11:39:36 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	private static Vector<Object> vector = new Vector<>();
	
	public static void main(String[] args) {
		Object element = new Object();
		
		//注：虽然Vector是线程安全的，但以下两个线程安全的操作合起来的操作，由于没有额外的同步，所以此复合操作不是线程安全的
		if (!vector.contains(element)) {
			vector.add(element);
		}
	}
}
