/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._6_dealingWithNon_InterruptibleBlocking;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ReaderThread.java $Date: May 21, 2013 1:53:34 PM -0400 2013
 * @since 1.0
 * 
 */
public class ReaderThread extends Thread {
	private static final int BUFSZ = 1024 * 1024;
	private final Socket socket;
	private final InputStream in;

	public ReaderThread(Socket socket) throws IOException {
		this.socket = socket;
		this.in = socket.getInputStream();
	}

	@Override
	public void interrupt() {
		try {
			socket.close();
		} catch (IOException ignored) {
		} finally {
			super.interrupt();
		}
	}

	public void run() {
		try {
			byte[] buf = new byte[BUFSZ];
			while (true) {
				int count = in.read(buf);
				if (count < 0)
					break;
				else if (count > 0)
					processBuffer(buf, count);
			}
		} catch (IOException e) { /* Allow thread to exit */
		}
	}

	private void processBuffer(byte[] buf, int count) {
		// TODO

	}
}
