/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._3_asyncIO._1_asynchronousFileChannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 对于文件通道来说，一般的操作，如读取和写入，都是同步进行的，调用者 会处于阻塞状态，以等待相应操作的完成。而对于套接字通道来说，阻塞式套接字通道
 * 的使用方式与文件通道相同，而非阻塞式套接字通道的使用方式则依靠选择器来完成。 异步通道一般提供两种使用方式：一种是通过Java
 * 同步工具包中的java.util.concurrent. Future 类的对象来表示异步操作的结果；另外一种是在执行操作时传入一个java.nio.
 * channels.CompletionHandler 接口的实现对象作为操作完成时的回调方法。这两种使用
 * 方式的区别只在于调用者通过何种方式来使用异步操作的结果。在使用Future 类的对象 时，要求调用者在合适的时机显式地通过Future 类的对象的get
 * 方法来得到实际的操作 结果；而在使用CompletionHandler 接口时，实际的调用结果作为回调方法的参数来给 出。
 * 
 * 
 * @author 周光明 Exp
 * @version $FileName: AsyncFileChannelUsage.java $Date: Apr 8, 2013 11:51:00 AM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class AsyncFileChannelUsage {

	/**
	 * 这里需要注意的是，异步文件通道并不支持FileChannel 类所提供的相对读写操作。
	 * 在异步文件通道中并没有当前读写位置的概念，因此所有的read 和write 方法在调用时 都必须显式地指定读写操作的位置
	 * 
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void asyncWrite() throws IOException, InterruptedException, ExecutionException {
		AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(Paths.get("large.txt"),
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		ByteBuffer byteBuffer = ByteBuffer.allocate(2 * 1024 * 1024);
		Future<Integer> future = asynchronousFileChannel.write(byteBuffer, 0);
		// 其它操作
		Integer len = future.get();
		System.out.println(len);
	}

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		AsyncFileChannelUsage.asyncWrite();
	}
}
