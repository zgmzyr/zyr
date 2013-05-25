/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._2_buffer;

import java.nio.CharBuffer;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CharBufferUsage.java $Date: Mar 30, 2013 2:26:31 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class CharBufferUsage {
	public void useCharBuffer() {
		CharBuffer buffer = CharBuffer.allocate(32);
		buffer.put("Hello World");
		System.out.println(buffer.position()); //11
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		CharBufferUsage cbu = new CharBufferUsage();
		cbu.useCharBuffer();
	}
}
