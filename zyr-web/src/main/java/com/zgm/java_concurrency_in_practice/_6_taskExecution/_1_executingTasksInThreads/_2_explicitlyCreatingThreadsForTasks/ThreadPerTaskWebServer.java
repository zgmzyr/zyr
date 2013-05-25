/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._6_taskExecution._1_executingTasksInThreads._2_explicitlyCreatingThreadsForTasks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  不要这么做
 * 
 * @author 周光明 Exp
 * @version $FileName: ThreadPerTaskWebServer.java $Date: May 17, 2013 10:48:38 AM -0400 2013
 * @since 1.0
 * 
 */
class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final  Socket connection = socket.accept();
            Runnable task = new Runnable() {
                    public void run() {
                        handleRequest(connection);
                    }

					private void handleRequest(Socket connection) {
						//TODO
						
					}
                };
            new Thread(task).start();
        }
    }
}


