/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._6_taskExecution._2_theExecutorFramework._4_executorLifecycle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LifecycleWebServer.java $Date: May 17, 2013 3:08:06 PM -0400 2013
 * @since 1.0
 * 
 */
class LifecycleWebServer {
//    private final ExecutorService exec = ...;
    private final ExecutorService exec = Executors.newCachedThreadPool(); 

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(8082);
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(new Runnable() {
                    public void run() { handleRequest(conn); }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown()) {
//                    log("task submission rejected", e);
                }
            }
        }
    }

    public void stop() { exec.shutdown(); }

    void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if (isShutdownRequest(req))
            stop();
        else
            dispatchRequest(req);
    }

	private Request readRequest(Socket connection) {
		//TODO
		return null;
	}

	private void dispatchRequest(Request req) {
		//TODO
		
	}

	private boolean isShutdownRequest(Request req) {
		//TODO
		return false;
	}
}
