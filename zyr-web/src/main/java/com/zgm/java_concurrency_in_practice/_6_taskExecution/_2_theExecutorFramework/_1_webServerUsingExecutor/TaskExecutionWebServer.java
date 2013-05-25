/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._6_taskExecution._2_theExecutorFramework._1_webServerUsingExecutor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TaskExecutionWebServer.java $Date: May 17, 2013 2:00:30 PM -0400 2013
 * @since 1.0
 * 
 */
class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec
        = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8082);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                public void run() {
                    handleRequest(connection);
                }

				private void handleRequest(Socket connection) {
					//TODO
					
				}
            };
            exec.execute(task);
        }
    }
}



