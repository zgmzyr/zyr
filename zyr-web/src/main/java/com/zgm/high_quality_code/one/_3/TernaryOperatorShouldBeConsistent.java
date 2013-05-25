/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.one._3;


/**
 * 三元操作符的类型务必一致
 * 
 * @author 周光明 Exp
 * @version $FileName: TernaryOperatorShouldBeConsistent.java $Date: 2012-6-16 下午10:19:26 -0400 2012
 * @since 1.0
 * 
 */
public class TernaryOperatorShouldBeConsistent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 80;
		String s1 = String.valueOf(i < 100 ? 90 : 100);
		String s2 = String.valueOf(i < 100 ? 90 : 100.0);
		
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = String.valueOf(i < 100 ? 90 : 100);
		String s4 = String.valueOf(i < 100 ? 90L : 100.0F);
		
		System.out.println(s3);
		System.out.println(s4);
	}

}
