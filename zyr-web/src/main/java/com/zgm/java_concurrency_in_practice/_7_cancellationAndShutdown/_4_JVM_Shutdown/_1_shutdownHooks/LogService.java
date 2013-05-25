/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._4_JVM_Shutdown._1_shutdownHooks;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._2_stoppingAThread_basedService._2_executorServiceShutdown.WriteTask;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LogService.java $Date: May 22, 2013 9:25:05 AM -0400 2013
 * @since 1.0
 * 
 */
public class LogService {
	private static final long TIMEOUT = 5;
	private final ExecutorService exec = Executors.newSingleThreadExecutor();
	private final PrintWriter writer;

	public LogService(PrintWriter writer) {
		super();
		this.writer = writer;
	}

	public void start() {
		//添加一个关闭钩子 
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					LogService.this.stop();
				} catch (InterruptedException ignored) {
				}
			}
		});

	}

	public void stop() throws InterruptedException {
		try {
			exec.shutdown();
			exec.awaitTermination(TIMEOUT, TimeUnit.MICROSECONDS);
		} finally {
			writer.close();
		}
	}

	public void log(String msg) {
		try {
			exec.execute(new WriteTask(msg));
		} catch (RejectedExecutionException ignored) {
		}
	}
}
