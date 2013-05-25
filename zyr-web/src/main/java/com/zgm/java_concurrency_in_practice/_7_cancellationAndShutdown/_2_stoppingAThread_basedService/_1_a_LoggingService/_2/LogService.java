/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._2_stoppingAThread_basedService._1_a_LoggingService._2;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LogService.java $Date: May 21, 2013 3:34:00 PM -0400 2013
 * @since 1.0
 * 
 */
public class LogService {

	private final BlockingQueue<String> queue;
	private final LoggerThread loggerThread;
	private final PrintWriter writer;
	// @GuardedBy("this")
	private boolean isShutdown;
	// @GuardedBy("this")
	private int reservations;

	public LogService(PrintWriter writer) {
		super();
		this.queue = new LinkedBlockingQueue<String>(4);
		this.loggerThread = new LoggerThread();
		this.writer = writer;
		// this.writer = new PrintWriter(System.out);
		// this.isShutdown = isShutdown;
		// this.reservations = reservations;
	}

	public void start() {
		loggerThread.start();
	}

	public void stop() {
		synchronized (this) {
			isShutdown = true;
		}
		loggerThread.interrupt();
	}

	public void log(String msg) throws InterruptedException {
		synchronized (this) {
			if (isShutdown) {
				// throw new IllegalStateException(...);
				throw new IllegalStateException("已经关闭");
			}

			++reservations;
		}

		queue.put(msg);
	}

	private class LoggerThread extends Thread {
		public void run() {
			try {
				while (true) {
					try {
						// synchronized (this) { //TODO 应该用 LogService 的内置锁 如下:
						synchronized (LogService.this) {
							if (isShutdown && reservations == 0)
								break;
						}

						String msg = queue.take();

						// synchronized (this) { //TODO 应该用 LogService 的内置锁
						synchronized (LogService.this) {
							--reservations;
						}

						writer.println(msg);
					} catch (InterruptedException e) { /* retry */
					}
				}
			} finally {
				writer.close();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		LogService logService = new LogService(new PrintWriter(System.out, true));
		logService.start();

		for (int count = 0; count < 6; count++) {
			logService.log("zyr" + count);
		}

		// logService.start();
	}
}
