/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._1_fileSystemCall._4_fileAttribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Map;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FileAttributes.java $Date: Apr 7, 2013 4:19:41 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class FileAttributes {
	public boolean checkUpdatesRequired(Path path, int intervalInMillis) throws IOException {
		FileTime lastModifiedTime = (FileTime) Files.getAttribute(path, "lastModifiedTime");
		long now = System.currentTimeMillis();
		return now - lastModifiedTime.toMillis() > intervalInMillis;
	}

	/**
	 *  Files.getFileAttributeView方法
	 * 获取到DosFileAttributeView 接口的实现对象之后，还需要调用 其readAttributes
	 * 方法来获取具体的包含属性的对象。从简化使用的角度出发，Files 类中 提供了readAttributes
	 * 方法来直接获取特定类型的BasicFileAttributes 接口的实现对象.
	 *  Files 类中的readAttributes
	 * 和getAttribute 方法可以根据属性名称来获取对应的 值。不同之处在于readAttributes
	 * 方法可以批量获取一组属性的值，而getAttribute 方法 只能获取一个属性的值。使用这两个方法时需要指定文件的路径及属性的名称。属性
	 * 的名称是带名称空间的，其前缀是属性所在的属性视图的名称，比如“DOS”文件属
	 * 性视图中的“是否为隐藏文件”属性的完整名称是“dos:hidden”。在不带前缀的情况
	 * 下，默认属性来自基本属性视图。在调用readAttributes 方法时，多个属性名称之间用逗号分隔即可。
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void testHidden(Path path) throws IOException {
		Boolean hidden = (Boolean) Files.getAttribute(path, "dos:hidden");
		System.out.println("是否是隐藏文件： " + hidden);

		Map<String, Object> attributeMap = Files.readAttributes(path, "dos:hidden,readonly,system,archive");
		for (Object key : attributeMap.keySet()) {
			System.out.println(key + "属性的值： " + attributeMap.get(key));
		}
	}

	/**
	 * Windows 操作系统中的文件系统一般使用遗留的“DOS”文件属性视图，由java.
	 * nio.file.attribute.DosFileAttributeView 接口来表示。DosFileAttributeView
	 * 接口中包含的属 性有是否为只读文件（readonly）、是否为隐藏文件（hidden）、是否为系统文件（system）
	 * 和是否为归档文件（archive）等。DosFileAttributeView 接口中包含了设置这些属性的
	 * 方法。如果需要获取属性的值，先通过readAttributes 方法获取到java.nio.file.attribute.
	 * DosFileAttributes 接口的实现对象，再调用该实现对象中的对应方法来获取属性值。与 DosFileAttributeView
	 * 接口相对应的是java.nio.file.attribute.PosixFileAttributeView 接口，表 示UNIX 和Linux
	 * 系统使用的POSIX 文件属性视图。PosixFileAttributeView 接口中包含的
	 * 属性有所有者信息（group）和权限信息（permissions）。PosixFileAttributeView 接口的使
	 * 用方式类似于DosFileAttributeView 接口，使用PosixFileAttributeView 接口本身提供的方
	 * 法来进行属性设置；通过readAttributes 方法获取java.nio.file.attribute.PosixFileAttributes
	 * 接 口的实现对象来读取属性的值
	 * 
	 * @throws IOException
	 */
	public void useFileAttributeView() throws IOException {
		Path path = Paths.get("content.txt");
		DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
		if (view != null) {
			DosFileAttributes attrs = view.readAttributes();
			System.out.println(attrs.isReadOnly());
			System.out.println(attrs.isHidden());
			System.out.println(attrs.isSystem());
			System.out.println(attrs.isDirectory());
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		FileAttributes fa = new FileAttributes();
		Path path = Paths.get("content.txt");
		boolean result = fa.checkUpdatesRequired(path, 500);
		System.out.println(result);

		fa.testHidden(path);
		fa.useFileAttributeView();
	}
}
