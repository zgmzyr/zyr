/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._2_superIsNotGenericButSubIsGeneric;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SubClass.java $Date: 2013-4-7 下午10:00:50 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSubClass<T> extends SuperClass {

	 //则编译错误
	public void method(T obj) {
		System.out.println("子类中的方法：" + obj);
	}

//	@Override //加上则编译错误, 不加上的话就是重载
	public void method2(T obj) {
		
		System.out.println("子类中的方法：" + obj);
	}
	
	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test1() {
		SuperClass superClass = new GenericSubClass<String>();
		superClass.method(new Object());
		
		GenericSubClass<String> subClass1 = (GenericSubClass<String>) superClass;
		subClass1.method2("zyr");
		
		GenericSubClass<Integer> subClass2 = (GenericSubClass<Integer>) superClass;
		subClass2.method2(Integer.MAX_VALUE);
	}

	private static void test2() {
		SuperClass superClass = new GenericSubClass<Integer>();//实际类型为Integer
		superClass.method(new Object());
		
		GenericSubClass<String> subClass1 = (GenericSubClass<String>) superClass;
		subClass1.method2("zyr");
//		subClass1.mehod(Integer.MAX_VALUE);
		subClass1.method(new Object());
		
		GenericSubClass<Integer> subClass2 = (GenericSubClass<Integer>) superClass;
		subClass2.method2(Integer.MAX_VALUE);
	}
}
