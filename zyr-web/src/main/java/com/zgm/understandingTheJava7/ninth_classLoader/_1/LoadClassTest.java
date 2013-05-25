/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._1;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LoadClassTest.java $Date: 2013-3-13 下午9:56:21 -0400 2013
 * @since 1.0
 * 
 */
public class LoadClassTest {

	public void loadClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ClassLoader current = super.getClass().getClassLoader();
		Class<?> clazz = current.loadClass("java.lang.String");
		Object str = clazz.newInstance();
		
		System.out.println(str.getClass());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		new LoadClassTest().loadClass();
	}
}
