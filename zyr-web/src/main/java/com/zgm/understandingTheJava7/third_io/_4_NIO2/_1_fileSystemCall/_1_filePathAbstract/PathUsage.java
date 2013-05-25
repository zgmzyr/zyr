/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._1_fileSystemCall._1_filePathAbstract;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PathUsage.java $Date: Apr 7, 2013 10:56:52 AM -0400 2013
 * @since 1.0
 * 
 */
public class PathUsage {

	public static void main(String[] args) {
		Path path1 = Paths.get("folder1", "sub1");
		Path path2 = Paths.get("folder2", "sub2");
		System.out.println(path1);
		System.out.println(path1.resolve(path2));
		System.out.println(path1.resolveSibling(path2));
		System.out.println(path1.relativize(path2));
		System.out.println(path1.startsWith(path2));
		System.out.println(path1.endsWith(path2));
		Path path3 = Paths.get("");
		System.out.println(path3);
		System.out.println(path1.startsWith(path3));
		System.out.println(path1.startsWith(Paths.get("folder1")));
		System.out.println(path1.startsWith(Paths.get("folder1/sub1")));
		System.out.println(path1.startsWith(path1));
		System.out.println(path1.endsWith(path1));
		System.out.println(path1.resolve(path2).endsWith(path2));
		System.out.println(path1.resolve(path2).endsWith(Paths.get("folder2")));
		System.out.println(path1.resolve(path2).endsWith(Paths.get("sub2")));
		
		System.out.println(Paths.get("folder1/./../folder2/my.text").normalize());
		System.out.println(Paths.get("folder1/./../../folder2/my.text").normalize());
	}
}
