/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2;

import java.nio.file.Path;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ParentLastClassLoader.java $Date: 2013-3-18 下午9:46:21 -0400 2013
 * @since 1.0
 * 
 */
//public class ParentLastClassLoader extends ClassLoader {
public class ParentLastClassLoader extends FileSystemClassLoader {

	public ParentLastClassLoader(Path path) {
		super(path);
	}

	@Override
	public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class<?> clazz = super.findLoadedClass(name);
		if (clazz != null) {
			return clazz;
		}
		
		clazz = super.findClass(name);
		if (clazz != null) {
			return clazz;
		}
		
		ClassLoader parentClassLoader = super.getParent();
		if (parentClassLoader != null) {
			return parentClassLoader.loadClass(name);
		} else {
			return super.loadClass(name);
		}
	}
}
