package com.zgm.java.lang.System;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author zhouguangming 创建时间: 2014年10月22日 下午7:59:12
 */

public class PrintlnTest2
{
	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Lock lock = new ReentrantLock(false);
		Runnable t1 = new MyRunnable2("张三", 1, lock);
		Runnable t2 = new MyRunnable2("李四", 2, lock);
		Runnable t3 = new MyRunnable2("王五", 3, lock);
		Runnable t4 = new MyRunnable2("老张", 4, lock);
		Runnable t5 = new MyRunnable2("老牛", 5, lock);
		Runnable t6 = new MyRunnable2("老朱", 6, lock);
		//执行各个线程
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);
		pool.execute(t6);
		//关闭线程池
		pool.shutdown();
	}
}

class MyRunnable2 implements Runnable
{
	private static AtomicLong aLong = new AtomicLong(10000); //原子量，每个线程都可以自由操作
	private String name; //操作人
	private int data; //操作数
	private Lock lock;

	MyRunnable2(String name, int data, Lock lock)
	{
		this.name = name;
		this.data = data;
		this.lock = lock;
	}

	public void run()
	{
		lock.lock();
//		System.out.println(name + "执行了" + data + "，当前余额：" + aLong.addAndGet(data));
		System.out.println(name + "执行了" + data + "，开始余额：" + aLong.get() + "，当前余额：" + aLong.addAndGet(data));
		lock.unlock();
	}
}
