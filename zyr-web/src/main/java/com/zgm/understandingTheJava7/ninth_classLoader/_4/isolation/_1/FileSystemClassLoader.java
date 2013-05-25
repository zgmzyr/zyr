/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FileSystemClassLoader.java $Date: 2013-3-18 下午9:02:52 -0400 2013
 * @since 1.0
 * 
 */
public class FileSystemClassLoader extends ClassLoader {
	private Path path;
	
	public FileSystemClassLoader(Path path) {
		this.path = path;
	}

	/*@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class<?> clazz = super.findLoadedClass(name);
		if (clazz != null) {
			return clazz;
		}
		
		clazz = this.findClass(name);
		if (clazz != null) {
			return clazz;
		}
		
		ClassLoader parent = super.getParent();
		if (parent != null) {
			return parent.loadClass(name);
		}
		
		return null;
	}*/
	
	/*protected Class<?> findLoadedClass(String name) {
		ClassLoader parent = super.getParent();
		if (parent != null) {
			return parent.loadClass(name);
		}
		
		return null;
	}*/
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] classData = this.getClassData(name);
			return super.defineClass(name, classData, 0, classData.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private byte[] getClassData(String className) throws IOException {
		Path path = this.classNameToPath(className);
		
		return Files.readAllBytes(path);
	}

	private Path classNameToPath(String className) {
		return path.resolve(className.replace(".", File.separator) + ".class");
	}
}
