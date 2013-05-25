/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.thinking_in_java.thread.executor_21_2_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zgm.thinking_in_java.thread._21_2_1.LiftOff;
import com.zgm.zen.state.example2.Lift;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CachedThreadPool.java $Date: 2012-4-11 下午10:18:39 -0400 2012
 * @since 1.0
 * 
 */
public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 5; i++) {
			executorService.execute(new LiftOff());
		}
		
		executorService.shutdown();
		
		System.out.println("main 方法执行结束！");
	}
}
