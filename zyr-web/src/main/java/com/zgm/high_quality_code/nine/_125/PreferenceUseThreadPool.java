/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._125;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PreferenceUseThreadPool.java $Date: 2012-5-14 下午10:07:49 -0400 2012
 * @since 1.0
 * 
 */
public class PreferenceUseThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 4; i++) {
			executorService.submit(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
				
			});
		}
		
		executorService.shutdown();
	}

}
