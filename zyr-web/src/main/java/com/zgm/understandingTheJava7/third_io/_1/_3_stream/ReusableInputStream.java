/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._1._3_stream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ReusableInputStream.java $Date: Mar 28, 2013 10:43:45 AM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class ReusableInputStream extends BufferedInputStream {

	private boolean readAttempted = false;

	public ReusableInputStream(InputStream input) {
		super(input);
	}

	public synchronized int read() throws IOException {
		return super.read();
	}

	public synchronized int read(byte[] b, int off, int len) throws IOException {
		return super.read(b, off, len);
	}

	public int read(byte[] b) throws IOException {
		return super.read(b);
	}

}
