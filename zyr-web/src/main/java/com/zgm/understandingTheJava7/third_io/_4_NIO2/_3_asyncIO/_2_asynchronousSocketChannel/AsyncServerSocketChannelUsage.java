/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._3_asyncIO._2_asynchronousSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: AsyncServerSocketChannelUsage.java $Date: Apr 8, 2013
 *          2:26:43 PM -0400 2013
 * @since 1.0
 * 
 */
public class AsyncServerSocketChannelUsage {

	/**
	 * 异步通道在处理I/O 请求时，需要使用一个java.nio.channels.AsynchronousChannel- Group
	 * 类的对象。AsynchronousChannelGroup 类的对象表示的是一个异步通道的分
	 * 组，每一个分组都有一个线程池与之关联，这个线程池中的线程用来处理I/O 事件。
	 * 多个异步通道可以共享一个分组的线程池资源。调用AsynchronousSocketChannel 和
	 * AsynchronousServerSocketChannel 类的open 方法打开异步套接字通道时，可以传入一
	 * 个AsynchronousChannelGroup 类的对象作为所使用的分组。如果调用open 方法时没
	 * 有传入AsynchronousChannelGroup 类的对象，默认使用系统提供的分组。需要注意的
	 * 是，系统分组对应的线程池中的线程是守护线程。如果代码清单3-27 中没有显式使用 AsynchronousChannelGroup
	 * 类的对象，程序启动之后会很快退出，因为系统分组使用的 守护线程不会阻止虚拟机退出。
	 * 
	 * @throws IOException
	 */
	public static void startAsyncSimpleServer() throws IOException {
		AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(5,
				Executors.defaultThreadFactory());
		final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(group).bind(
				new InetSocketAddress(10080));

		serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

			@Override
			public void completed(AsynchronousSocketChannel clientChannel, Void attachment) {
				serverChannel.accept(null, this);

				try {
					clientChannel.write(ByteBuffer.wrap("Hello".getBytes("UTF-8")));
					clientChannel.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

			@Override
			public void failed(Throwable exc, Void attachment) {
				exc.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) throws IOException {
		AsyncServerSocketChannelUsage.startAsyncSimpleServer();
	}
}
