/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader.loadCustomeString;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2.ParentLastClassLoader;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LoadCustomeString.java $Date: 2013-4-1 下午10:04:32 -0400 2013
 * @since 1.0
 * 
 */
public class LoadCustomeString {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
		Path path = Paths.get("classData");
		String className = "java.lang.String";
		
		ClassLoader parentLastClassLoader = new ParentLastClassLoader(path); 
	    Class<?> clazz = parentLastClassLoader.loadClass(className);
	    Object string = clazz.newInstance();
	    Method method = clazz.getMethod("printInformation", null);
	    method.invoke(string, null);
		
	}
}
