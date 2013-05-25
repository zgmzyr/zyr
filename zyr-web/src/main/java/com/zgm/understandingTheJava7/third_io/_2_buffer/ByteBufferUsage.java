/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._2_buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ByteBufferUsage.java $Date: Mar 25, 2013 2:04:54 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class ByteBufferUsage {
	public void useByteBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put((byte) 1);
		buffer.put(new byte[3]);
		buffer.putChar('A');
		buffer.putFloat(0.0f);
		buffer.putLong(10, 100L);
		System.out.println(buffer.getChar(4));
		System.out.println(buffer.getChar());
		System.out.println(buffer.remaining());
	}

	public void byteOrder() {
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putInt(1);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		System.out.println(buffer.getInt(0)); // 值为16777216
	}

	public void compact() {
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put(new byte[16]);
		//把读写限制设为当前的读写位置，再把读写位置设为0，这样可以保证缓冲区中的全部 数据都可以被读取
		buffer.flip();
		System.out.println(buffer.getInt());
		/*
		 * 压缩操作就是把ByteBuffer 类的对 象中当前读写位置到读写限制范围内的数据复制到内部存储空间中的最前面，然后再把
		      读写位置移动到紧接着复制完成的数据的下一个位置，读写限制也被设置成ByteBuffer 类的对象的容量。经过压缩之后，
		      发送者的下次写入操作就不会覆盖接收者还没读取的 内容，而接收者每次总是可以从ByteBuffer 类的对象的起始位置进行读取
		 */
		buffer.compact();
		int pos = buffer.position();
		System.out.println("pos: " + pos);
	}

	public void viewBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.putInt(1);
		IntBuffer intBuffer = buffer.asIntBuffer();
		intBuffer.put(2);
		
		System.out.println("buffer.position: " + buffer.position());
		System.out.println("buffer.position: " + intBuffer.position());
		
		int value = buffer.getInt(); // 值为2
		System.out.println("value: " + value);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		ByteBufferUsage bbu = new ByteBufferUsage();
		bbu.useByteBuffer();
		bbu.byteOrder();
		bbu.compact();
		bbu.viewBuffer();
		
		bbu.userAllocateDirectByteBuffer();
	}

	private void userAllocateDirectByteBuffer() {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(32);
		byteBuffer.put((byte) 1);
		byteBuffer.putInt(2);
	}
		
}
