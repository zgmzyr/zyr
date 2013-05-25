/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.thinking_in_java.thread.return_value_21_2_4;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CallableDemo.java $Date: 2012-4-13 下午10:10:11 -0400 2012
 * @since 1.0
 * 
 */
public class CallableDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++) {
			results.add(executorService.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> future : results) {
			try {
//				System.out.println("get : " + future.get());
				try {
					System.out.println("get : " + future.get(2, TimeUnit.SECONDS));
				} catch (TimeoutException e) {
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("aa！");
		}
		
		System.out.println("main 方法执行结束！");
	}

}
