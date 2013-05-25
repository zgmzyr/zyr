/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.two_27;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Client.java $Date: 2012-5-2 下午10:36:46 -0400 2012
 * @since 1.0
 * 
 */
public class Client {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		
		
		compare(i, j);
		
		int k = 100;
		compare2(i, k);
		
	}

	private static void compare(Integer i, Integer j) {
		System.out.println(i == j);
		System.out.println(i > j);
		System.out.println(i < j);
		
	}
	
	private static void compare2(Integer i, int j) {
		System.out.println(i == j);
		System.out.println(i > j);
		System.out.println(i < j);
		
	}
}
