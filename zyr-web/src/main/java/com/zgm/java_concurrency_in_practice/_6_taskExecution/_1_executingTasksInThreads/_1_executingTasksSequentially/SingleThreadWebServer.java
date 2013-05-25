/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._6_taskExecution._1_executingTasksInThreads._1_executingTasksSequentially;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SingleThreadWebServer.java $Date: May 17, 2013 10:40:31 AM -0400 2013
 * @since 1.0
 * 
 */
class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

	private static void handleRequest(Socket connection) {
		//TODO
		
	}
}
