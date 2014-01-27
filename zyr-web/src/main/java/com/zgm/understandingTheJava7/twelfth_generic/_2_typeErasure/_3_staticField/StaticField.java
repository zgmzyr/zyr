/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._2_typeErasure._3_staticField;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: StaticField.java $Date: 2013-4-4 上午10:44:57 -0400 2013
 * @since 1.0
 * 
 */
public class StaticField<T> {
	public static int count = 0;

	public StaticField() {
		count++;
	}
	
	public static void main(String[] args) {
		new StaticField<>();
		new StaticField<String>();
		new StaticField<Integer>();
		
		System.out.println("count=" + count);
	}
}
