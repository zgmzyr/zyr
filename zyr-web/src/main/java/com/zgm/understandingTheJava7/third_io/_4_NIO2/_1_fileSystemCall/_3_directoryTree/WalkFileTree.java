/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._1_fileSystemCall._3_directoryTree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: WalkFileTree.java $Date: Apr 7, 2013 2:06:55 PM -0400 2013
 * @since 1.0
 * 
 */
public class WalkFileTree {

	private static void cleanSVNInfo() throws IOException {
		Path path = Paths.get("E:/i/spring-security-test");
		Files.walkFileTree(path, new SvnInfoCleanVisitor());
	}
	
	private static class SvnInfoCleanVisitor extends SimpleFileVisitor<Path> {
		private boolean cleanMark = false;
		
		private boolean isSvnFolder(Path dir) {
			return ".svn".equals(dir.getFileName().toString());
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			if (this.isSvnFolder(dir)) {
				cleanMark = true;
			}
			
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			if (this.cleanMark) {
				Files.setAttribute(file, "dos:readonly", false);
				Files.delete(file);
			}
			
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			if (exc == null && this.cleanMark) {
				Files.delete(dir);
				
				if (this.isSvnFolder(dir)) {
					this.cleanMark = false;
				}
			}
			
			return FileVisitResult.CONTINUE;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		WalkFileTree.cleanSVNInfo();
	}
}
