/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._2_stoppingAThread_basedService._4_aOne_shotExecutionService;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 只执行一次的任务
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 23, 2013 9:28:07 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	
	public static void main(String[] args) {
		Set<String> hosts = new HashSet<>();
		hosts.add("zyr");
		hosts.add("zyr");
		hosts.add("zgm");
		
		try {
			new Test().checkMail(hosts, 0, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			//TODO
			e.printStackTrace();
		}
	}
	
	boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		//TODO 只所以用AtomicBoolean类型，而不是volatile类型的，是因为hasNewMail要在Runable的内部访问，而此种要求
		//是final修饰的
		final AtomicBoolean hasNewMail = new AtomicBoolean(false);
		
		try {
			for (final String host : hosts)
				exec.execute(new Runnable() {
					public void run() {
						if (checkMail(host))
							hasNewMail.set(true);
					}

					private boolean checkMail(String host) {
						// TODO
						return false;
					}
				});
		} finally {
			exec.shutdown();
			exec.awaitTermination(timeout, unit);
		}
		
		return hasNewMail.get();
	}

}
