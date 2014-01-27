/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._4_wildcard;

import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ObjectFactory.java $Date: 2013-4-4 下午9:28:37 -0400 2013
 * @since 1.0
 * 
 */
public class ObjectFactory {

	public static <T> T create(Class<T> interfaceType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String className = "java.util.ArrayList";
		Class<?> clazz = Class.forName(className);
		
		return interfaceType.cast(clazz.newInstance());
//		return clazz.newInstance();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		List list = create(List.class);
		System.out.println("list: " + list);
	}
}
