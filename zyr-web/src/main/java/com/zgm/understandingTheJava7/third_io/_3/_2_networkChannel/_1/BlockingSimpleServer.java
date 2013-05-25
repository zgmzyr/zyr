/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._3._2_networkChannel._1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BlockingSimpleServer.java $Date: Apr 3, 2013 3:04:57 PM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class BlockingSimpleServer {
	public void startSimpleServer() throws IOException {
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.bind(new InetSocketAddress("localhost", 10800));
		while (true) {
			try (SocketChannel sc = channel.accept()) {
				sc.write(ByteBuffer.wrap("Hello".getBytes("UTF-8")));
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		BlockingSimpleServer bss = new BlockingSimpleServer();
		bss.startSimpleServer();
	}
}
