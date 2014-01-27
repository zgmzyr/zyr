/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.overload;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Overload.java $Date: 2013-4-13 下午9:39:10 -0400 2013
 * @since 1.0
 * 
 */
public class Overload {

	public static void staticMethod(Object obj) {
		System.out.println("static: 参数类型为Object");
	}
	
	public static void staticMethod(String string) {
		System.out.println("static: 参数类型为String");
	}
	
	public static void method(Integer integer) {
		System.out.println("static: 参数类型为Integer");
	}
	
	public void method(Object obj) {
		System.out.println("参数类型为Object");
	}
	
	public void method(String obj) {
		System.out.println("参数类型为String");
	}
	
	public static void main(String[] args) {
		staticMethod(11.1);
		staticMethod("zyr");
		method(11);
		
		Overload o = new Overload();
		o.method(11.1);
		o.method("zyr");
		
	}
}
