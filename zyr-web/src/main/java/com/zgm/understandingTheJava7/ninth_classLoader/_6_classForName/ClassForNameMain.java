/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._6_classForName;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2.ParentLastClassLoader;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ClassForNameMain.java $Date: 2013-3-27 下午10:10:51 -0400
 *          2013
 * @since 1.0
 * 
 */
public class ClassForNameMain {
	public void classForNameVsLoader() throws ClassNotFoundException {
		String className = "com.zgm.understandingTheJava7.ninth_classLoader._6_classForName.ClassForNameTest";
		//当只有一个参数时，相当于第二个参数为true，第三个参数为this.getClass().getClassLoader()
//		Class<?> clazz1 = Class.foame(className);
//		Class<?> clazz1 = Class.forName(className true, null);//当第3个参数为null时，使用启动类加载器去加载，会报错的
		Path path = Paths.get("understandingTheJava7/classForName");
		Class<?> clazz1 = Class.forName(className, true, new ParentLastClassLoader(path));
		ClassLoader loader = this.getClass().getClassLoader();
		Class<?> clazz2 = loader.loadClass(className);
		
		System.out.println("clazz1 == clazz2 :" + (clazz1 == clazz2));
	}

	public static void main(String[] args) {
		ClassForNameMain main = new ClassForNameMain();
		try {
			main.classForNameVsLoader();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
