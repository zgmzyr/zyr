/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._1._3_stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ExpressionParser.java $Date: Mar 28, 2013 10:47:26 AM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class ExpressionParser {
	public void parse(InputStream input) throws IOException {
		PushbackInputStream pinput = new PushbackInputStream(input);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		int data;
		while ((data = pinput.read()) != -1) {
			if (data == '+') {
				pinput.unread(data);
			} else {
				output.write(data);
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
	}
}
