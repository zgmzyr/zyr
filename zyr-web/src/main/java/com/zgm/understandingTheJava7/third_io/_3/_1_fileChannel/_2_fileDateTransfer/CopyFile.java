/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._3._1_fileChannel._2_fileDateTransfer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CopyFile.java $Date: Apr 2, 2013 9:53:41 AM -0400 2013
 * @since 1.0
 * 
 */
public class CopyFile {
//	private String srcFilename = "src.data";
//	private String destFilename = "dest.data";
	private String srcFilename = "understandingTheJava7/third_io/_3/_1_fileChannel/src.txt";
	private String destFilename = "understandingTheJava7/third_io/_3/_1_fileChannel/dest.txt";

	public void copyUseByteArray() throws IOException {
		byte[] buffer = new byte[32 * 1024];//		byte[] buffer = new byte[24];		int len = -1;
		try (FileInputStream input = new FileInputStream(srcFilename);
				FileOutputStream output = new FileOutputStream(destFilename + "1")) {
			while ((len = input.read(buffer)) != -1) {
				output.write(buffer, 0, len);
			}
		}
	}

	public void copyUseByteBuffer() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocateDirect(32 * 1024);
		try (FileChannel src = FileChannel.open(Paths.get(srcFilename), StandardOpenOption.READ);
				FileChannel dest = FileChannel.open(Paths.get(destFilename + "2"), StandardOpenOption.WRITE,
						StandardOpenOption.CREATE)) {
			while (src.read(buffer) > 0 || buffer.position() != 0) {
				buffer.flip();
				dest.write(buffer);
				buffer.compact();
			}
		}
	}

	public void copyUseChannelTransfer() throws IOException {
		try (FileChannel src = FileChannel.open(Paths.get(srcFilename), StandardOpenOption.READ);
				FileChannel dest = FileChannel.open(Paths.get(destFilename + "3"), StandardOpenOption.WRITE,
						StandardOpenOption.CREATE)) {
			src.transferTo(0, src.size(), dest);
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		CopyFile cf = new CopyFile();
		long t1 = System.currentTimeMillis();
		 cf.copyUseByteArray();
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		cf.copyUseByteBuffer();
		long t3 = System.currentTimeMillis();
		System.out.println(t3 - t2);
		 cf.copyUseChannelTransfer();
		long t4 = System.currentTimeMillis();
		System.out.println(t4 - t3);
	}
}
