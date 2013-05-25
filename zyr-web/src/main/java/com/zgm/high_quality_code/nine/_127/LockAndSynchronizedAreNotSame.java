/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._127;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LockAndSynchronizedAreNotSame.java $Date: 2012-5-15
 *          下午9:04:39 -0400 2012
 * @since 1.0
 * 
 */
public class LockAndSynchronizedAreNotSame {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
		runTasks(TaskWithLock.class);
		
		runTasks(TaskWithSynchronization.class);

	}

	public static void runTasks(Class<? extends Runnable> clz)
			throws InstantiationException, IllegalAccessException,
			InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		System.out.println("****开始执行" + clz.getSimpleName() + "任务****");

		for (int i = 0; i < 3; i++) {
			executorService.submit(clz.newInstance());
		}

		TimeUnit.SECONDS.sleep(10);

		System.out.println("-----" + clz.getSimpleName() + "任务执行完毕-----\n");
		
		executorService.shutdown();
	}

}
