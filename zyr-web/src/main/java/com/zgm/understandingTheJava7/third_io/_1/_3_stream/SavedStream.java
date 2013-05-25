/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._1._3_stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SavedStream.java $Date: Mar 25, 2013 1:42:01 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class SavedStream {
	private InputStream input;
	private byte[] data = new byte[0];

	public SavedStream(InputStream input) throws IOException {
		this.input = input;

		save();
	}

	private void save() throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = input.read(buffer)) != -1) {
			output.write(buffer, 0, len);
		}
		data = output.toByteArray();
	}

	public InputStream getInputStream() {
		return new ByteArrayInputStream(data);
	}
}
