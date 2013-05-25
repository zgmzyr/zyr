/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._3._1_fileChannel._1_readAndWrite;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FileChannelUsage.java $Date: Mar 30, 2013 3:23:04 PM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class FileChannelUsage {
	public void openAndWrite() throws IOException {
//		FileChannel channel = FileChannel
//				.open(Paths.get("my.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
		FileChannel channel = FileChannel
				.open(Paths.get("my.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		ByteBuffer buffer = ByteBuffer.allocate(64);
		buffer.putChar('A').flip();
		channel.write(buffer);
	}

	public void readWriteAbsolute() throws IOException {
		FileChannel channel = FileChannel.open(Paths.get("absolute.txt"), StandardOpenOption.READ,
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		ByteBuffer writeBuffer = ByteBuffer.allocate(4).putChar('A').putChar('B');
		writeBuffer.flip();
		channel.write(writeBuffer, 1024);
		ByteBuffer readBuffer = ByteBuffer.allocate(2);
		channel.read(readBuffer, 1026);
		readBuffer.flip();
		char result = readBuffer.getChar(); // 值为'B'
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		FileChannelUsage fcu = new FileChannelUsage();
		fcu.openAndWrite();
		fcu.readWriteAbsolute();
	}
}
