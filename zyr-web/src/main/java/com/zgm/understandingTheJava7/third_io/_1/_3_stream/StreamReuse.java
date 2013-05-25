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
 * @version $FileName: StreamReuse.java $Date: Mar 25, 2013 10:03:21 AM -0400
 *          2013
 * @since 1.0
 * 
 */
public class StreamReuse {
	private InputStream input;

	public StreamReuse(InputStream input) {
		if (!input.markSupported()) {
			this.input = new BufferedInputStream(input);
		} else {
			this.input = input;
		}
	}

	public InputStream getInputStream() {
		input.mark(Integer.MAX_VALUE);
		return input;
	}

	public void markUsed() throws IOException {
		input.reset();
	}
}
