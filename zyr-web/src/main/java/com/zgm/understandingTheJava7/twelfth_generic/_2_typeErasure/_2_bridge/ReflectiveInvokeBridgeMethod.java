/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._2_typeErasure._2_bridge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ReflectiveInvokeBridgeMethod.java $Date: 2013-4-2 下午9:31:36 -0400 2013
 * @since 1.0
 * 
 */
public class ReflectiveInvokeBridgeMethod {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		commonMethod();
		
		bridgeMethod();
	}

	private static void bridgeMethod() throws InstantiationException,
			IllegalAccessException, NoSuchMethodException,
			InvocationTargetException {
		Class<Sequence> clazz = Sequence.class;
//		Sequence sequence = clazz.newInstance();
		Method bridgeMethod = clazz.getDeclaredMethod("compareTo", Object.class);
		System.out.println("是否是桥接方法：" + bridgeMethod.isBridge());
		
		Sequence sequence1 = new Sequence(1);
		Sequence sequence2 = new Sequence(2);
		Object result = bridgeMethod.invoke(sequence1, sequence2);
		System.out.println("result: " + result);
		
		bridgeMethod.invoke(sequence1, "zyr");
	}

	private static void commonMethod() throws InstantiationException,
			IllegalAccessException, NoSuchMethodException,
			InvocationTargetException {
		Class<Sequence> clazz = Sequence.class;
		Sequence sequence = clazz.newInstance();
		
		Method compareToMethod = clazz.getMethod("compareTo", Sequence.class);
		System.out.println("是否是桥接方法：" + compareToMethod.isBridge());
		
		Object result = compareToMethod.invoke(sequence, new Sequence(5));
		System.out.println("result: " + result);
	}
}
