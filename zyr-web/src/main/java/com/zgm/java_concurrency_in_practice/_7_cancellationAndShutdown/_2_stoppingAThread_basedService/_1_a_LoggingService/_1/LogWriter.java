/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._2_stoppingAThread_basedService._1_a_LoggingService._1;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *  存在的问题：关闭机制不完备
 * 
 * @author 周光明 Exp
 * @version $FileName: LogWriter.java $Date: May 21, 2013 3:07:11 PM -0400 2013
 * @since 1.0
 * 
 */
public class LogWriter {
	private static final int CAPACITY = 20;
	private final BlockingQueue<String> queue;
	private final LoggerThread logger;

	public LogWriter(PrintWriter writer) {
		this.queue = new LinkedBlockingQueue<String>(CAPACITY);
		this.logger = new LoggerThread(writer);
	}

	public void start() {
		logger.start();
	}

	public void log(String msg) throws InterruptedException {
		queue.put(msg);
	}

	private class LoggerThread extends Thread {
		private final PrintWriter writer;

		public LoggerThread(PrintWriter writer) {
			super();
			this.writer = writer;
		}

		// ...
		public void run() {
			try {
				while (true)
					writer.println(queue.take());
			} catch (InterruptedException ignored) {
			} finally {
				writer.close();
			}
		}
	}
}
