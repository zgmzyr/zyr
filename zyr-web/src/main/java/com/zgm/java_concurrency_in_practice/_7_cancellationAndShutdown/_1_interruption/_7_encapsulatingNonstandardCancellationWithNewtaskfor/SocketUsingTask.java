/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._7_encapsulatingNonstandardCancellationWithNewtaskfor;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SocketUsingTask.java $Date: May 21, 2013 2:26:37 PM -0400 2013
 * @since 1.0
 * 
 */
public abstract class SocketUsingTask<T> implements CancellableTask<T> {
//	@GuardedBy("this")
	private Socket socket;

	protected synchronized void setSocket(Socket s) {
		socket = s;
	}

	public synchronized void cancel() {
		try {
			if (socket != null)
				socket.close();
		} catch (IOException ignored) {
		}
	}

	public RunnableFuture<T> newTask() {
		return new FutureTask<T>(this) {
			public boolean cancel(boolean mayInterruptIfRunning) {
				boolean cancel = false;
				try {
					SocketUsingTask.this.cancel();
				} finally {
					//不应该在finally 块中返回值
//					return super.cancel(mayInterruptIfRunning);
					super.cancel(mayInterruptIfRunning);
				}
				
				return cancel;
			}
		};
	}
}
