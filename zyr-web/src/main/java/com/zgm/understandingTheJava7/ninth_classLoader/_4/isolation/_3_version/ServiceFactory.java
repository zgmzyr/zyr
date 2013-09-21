/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._3_version;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2.FileSystemClassLoader;
import com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2.ParentLastClassLoader;


/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ServiceFactory.java $Date: 2013-3-27 下午9:16:09 -0400 2013
 * @since 1.0
 * 
 */
public class ServiceFactory {
	public static Versionized getService(String className, String version)
			throws Exception {
//		Path path = Paths.get("service", version);
		Path path = Paths.get("understandingTheJava7/service", version);
		FileSystemClassLoader loader = new ParentLastClassLoader(path);
		Class<?> clazz = loader.loadClass(className);
		return (Versionized) clazz.newInstance();
	}
}
