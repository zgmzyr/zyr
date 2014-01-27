/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._0;

import java.util.ArrayList;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: OverrideTest.java $Date: 2013-4-5 下午8:09:24 -0400 2013
 * @since 1.0
 * 
 */
public class OverrideTest {

	public static void main(String[] args) {
//		SubClass subClass = new SubClass();
		SuperClass subClass = new SubClass();
//		subClass.method(new ArrayList<>());
//		subClass.method(new ArrayList<>());
		subClass.method(new ArrayList());
	}
	
	public static void test1() {
		SubClass subClass = new SubClass();
		subClass.method(new ArrayList<>());
	}
	
	public static void test2() {
		SuperClass subClass = new SubClass();
		subClass.method(new ArrayList());
	}
	
	public static void test3() {
		SuperClass subClass = new SubClass();
		subClass.method(new ArrayList<>()); 
	}
	
	public static void test4() {
		SubClass subClass = new SubClass();
		subClass.method(new ArrayList());
	}
}
