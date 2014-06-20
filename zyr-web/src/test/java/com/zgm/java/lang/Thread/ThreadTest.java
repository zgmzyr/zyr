package com.zgm.java.lang.Thread;

/**
 * @author zhouguangming 创建时间: 2014年5月23日 下午5:44:21
 */
public class ThreadTest {
	public static void main(String[] args) {
		{
			long times = 1000_000L;
			long start = System.nanoTime();
			Object obj = new Object();
			for (int i = 0; i < times; ++i) {
				getCurrentThread().equals(obj);
			}
			long end = System.nanoTime();
			System.out.println("time:" + (end - start));
		}

		{
			long times = 1000_000L;
			long start = System.nanoTime();
			Object obj = new Object();
			for (int i = 0; i < times; ++i) {
				getStackTrace().equals(obj);
			}
			long end = System.nanoTime();
			System.out.println("time:" + (end - start));
		}
		
		{
			long times = 1000_000L;
			long start = System.nanoTime();
			Object obj = new Object();
			for (int i = 0; i < times; ++i) {
				new Throwable().getStackTrace().equals(obj);
			}
			long end = System.nanoTime();
			System.out.println("time:" + (end - start));
		}
	}

	static Object getCurrentThread() {
		return Thread.currentThread();
	}

	static Object getStackTrace() {
		return Thread.currentThread().getStackTrace();
	}

}
