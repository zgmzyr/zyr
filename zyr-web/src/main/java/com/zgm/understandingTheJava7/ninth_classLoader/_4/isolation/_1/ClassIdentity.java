/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._1;

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
//		Path path = Paths.get("designPatterns/WEB-INF/classes");
//		Path path = Paths.get("WEB-INF/classes");
		FileSystemClassLoader fileSystemClassLoader1 = new FileSystemClassLoader(path);
		FileSystemClassLoader fileSystemClassLoader2 = new FileSystemClassLoader(path);
		String className = "com.zgm.understandingTheJava7.ninth_classLoader._4.isolation.Sample";
//		String className = "ninth_classLoader._4.isolation.Sample";
		
		Class<?> clazz1 = fileSystemClassLoader1.loadClass(className);
		Object obj1 = clazz1.newInstance();
		Class<?> clazz2 = fileSystemClassLoader2.loadClass(className);
		Object obj2 = clazz2.newInstance();
		
		Method method = clazz1.getMethod("setSample", Object.class);
		System.out.println(clazz1 == clazz2);
		method.invoke(obj1, obj2);
	}
}
