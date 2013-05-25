/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._1_fileSystemCall._2_directoryStream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ListFile.java $Date: Apr 7, 2013 11:41:48 AM -0400 2013
 * @since 1.0
 * 
 */
public class ListFile {

	public static void listFiles() throws IOException {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(""))) {
			for (Path path : directoryStream) {
				System.out.println(path);
			}
		}
	}

	public static void listFiles2() throws IOException {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(""), "*.log")) {
			for (Path path : directoryStream) {
				System.out.println(path);
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		ListFile.listFiles();
		ListFile.listFiles2();
	}
}
