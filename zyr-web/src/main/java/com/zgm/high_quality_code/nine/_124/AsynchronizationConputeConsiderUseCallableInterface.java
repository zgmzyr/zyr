/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._124;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: AsynchronizationConputeConsiderUseCallableInterface.java $Date: 2012-5-14 下午9:26:01 -0400 2012
 * @since 1.0
 * 
 */
public class AsynchronizationConputeConsiderUseCallableInterface implements
		Callable<Integer> {
	
	private int seedMoney;

	public AsynchronizationConputeConsiderUseCallableInterface(int seedMoney) {
		this.seedMoney = seedMoney;
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws ExecutionException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<Integer> future = executorService.submit(new AsynchronizationConputeConsiderUseCallableInterface(100));
		
		while (!future.isDone()) {
			TimeUnit.MILLISECONDS.sleep(200);
			
			System.out.print("#");
		}
		 
		System.out.println("\n计算完成，税金是： " + future.get() + "元");
		
		executorService.shutdown();
	}

	@Override
	public Integer call() throws Exception {
		TimeUnit.MILLISECONDS.sleep(10000);
		return seedMoney;
	}

}
