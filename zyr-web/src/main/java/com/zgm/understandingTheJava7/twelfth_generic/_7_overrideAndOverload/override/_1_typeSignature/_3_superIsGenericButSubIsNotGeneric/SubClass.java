/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._3_superIsGenericButSubIsNotGeneric;

import java.lang.reflect.Method;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SubClass2.java $Date: 2013-4-9 下午9:18:32 -0400 2013
 * @since 1.0
 * 
 */
public class SubClass extends GenericSuperClass<Number> {//声明了形式参数的实际类型

	@Override 
	public void method(Number obj) {
		System.out.println("子类中的方法: " + obj);
	}
	
    //编译错误 
	/*	
	public void method(Object obj) {
		System.out.println("子类中的方法: " + obj);
	}
	*/
	
	@Override
	public void method2(Object obj) {
		System.out.println("子类中的方法: " + obj);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
//		SubClass.class.getDeclaredMethods();
		Method[] methods = SubClass.class.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
			Class<?>[] clazzs =  method.getParameterTypes();
			for (Class<?> clazz : clazzs) {
				System.out.println("参数类型：" + clazz.getName());
			}
			
			System.out.println(method.isBridge());
			System.out.println("==========================");
		}
	}
}
