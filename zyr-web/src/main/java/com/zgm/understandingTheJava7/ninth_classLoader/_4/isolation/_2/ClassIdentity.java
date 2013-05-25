/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ClassIdentity.java $Date: 2013-3-18 下午10:12:14 -0400 2013
 * @since 1.0
 * 
 */
public class ClassIdentity {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Path path = Paths.get("classData");
		ParentLastClassLoader parentLastClassLoader1 = new ParentLastClassLoader(path);
		ParentLastClassLoader parentLastClassLoader2  = new ParentLastClassLoader(path);
//		String className = "com.zgm.understandingTheJava7.ninth_classLoader._4.isolation.Sample";
		String otherClassName = "com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2.Sample";
		
		Class<?> clazz1 = parentLastClassLoader1.loadClass(otherClassName);
		Object obj1 = clazz1.newInstance();
		Class<?> clazz2 = parentLastClassLoader2.loadClass(otherClassName);
		Object obj2 = clazz2.newInstance();
		
		Method method = clazz1.getMethod("setSample", Object.class);
		System.out.println(clazz1 == clazz2);
		method.invoke(obj1, obj2);
	}
}
