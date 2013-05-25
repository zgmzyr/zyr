/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._1_fileSystemCall._6_operateFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FilesUtils.java $Date: Apr 8, 2013 9:17:23 AM -0400 2013
 * @since 1.0
 * 
 */
public class FilesUtils {
	
	public static void operateFile() throws IOException {
		Path newFile = Files.createFile(Paths.get("new.text"));
		List<String> content = new ArrayList<String>();
		content.add("自由人");
		content.add("zgm");
		Files.write(newFile, content, Charset.forName("UTF-8"));
		
		content.add("zyr");
		Files.write(newFile, content.toString().getBytes("UTF-8"));
		
		System.out.println("文件大小： " + Files.size(newFile));
		
		byte[] bytes = Files.readAllBytes(newFile);
		System.out.println("文件内容： " + bytes.toString());
		System.out.println("文件内容： " + new String(bytes));
		System.out.println("文件内容： " + new String(bytes, Charset.defaultCharset()));
		System.out.println("文件内容： " + new String(bytes, Charset.forName("UTF-8")));
		System.out.println("文件内容： " + new String(bytes, Charset.forName("utf-8")));
		System.out.println("文件内容： " + new String(bytes, Charset.forName("GBK")));
		
		List<String> contenList = Files.readAllLines(newFile, Charset.forName("UTF-8"));
		System.out.println("文件内容： " + contenList.toString());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Files.copy(newFile, baos);
		
		Files.delete(newFile);
		Files.deleteIfExists(newFile);
	}
	
	public static void main(String[] args) throws IOException {
		FilesUtils.operateFile();
	}
}
