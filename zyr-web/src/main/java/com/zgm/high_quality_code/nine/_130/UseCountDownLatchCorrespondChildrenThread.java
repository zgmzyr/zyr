/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._130;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: UseCountDownLatchCorrespondChildrenThread.java $Date: 2012-6-13 下午9:55:39 -0400 2012
 * @since 1.0
 * 
 */
public class UseCountDownLatchCorrespondChildrenThread {

	static class Runner implements Callable<Integer> {
		private CountDownLatch begin;
		private CountDownLatch end;
		
		public Runner(CountDownLatch begin, CountDownLatch end) {
			this.begin = begin;
			this.end = end;
		}
		
		@Override
		public Integer call() throws Exception {
			int score = new Random().nextInt(25);
			begin.await();
			TimeUnit.MILLISECONDS.sleep(score);
			end.countDown();
			
			return score;
		}
		
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int num = 10;
		CountDownLatch begin = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(num);
		ExecutorService executorService = Executors.newFixedThreadPool(num);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		
		for (int i = 0; i < num; i++) {
			futures.add(executorService.submit(new Runner(begin, end)));
		}
		
		begin.countDown();
		end.await();
		
		int count = 0;
		for (Future<Integer> future : futures) {
			count += future.get();
		}
	
		System.out.println("平均分数为： " + count / num);
	}

}
