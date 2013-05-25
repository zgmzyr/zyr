/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._115;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GetStackTraceFromThrowable.java $Date: 2012-5-12 下午10:04:57 -0400 2012
 * @since 1.0
 * 
 */
public class GetStackTraceFromThrowable {

	public static void main(String[] args) {
		Invoker.m1();
		Invoker.m2();
	}
	
	public static boolean m() {
		StackTraceElement[] stes = new Throwable().getStackTrace();
		
		for (StackTraceElement ste : stes) {
			if (ste.getMethodName().equals("m1")) {
				return true;
			}
		}
		
		return false;
	}
}

class Invoker {
	public static void m1() {
		System.out.println(GetStackTraceFromThrowable.m());
	}
	
	public static void m2() {
		System.out.println(GetStackTraceFromThrowable.m());
	}
	
	
}