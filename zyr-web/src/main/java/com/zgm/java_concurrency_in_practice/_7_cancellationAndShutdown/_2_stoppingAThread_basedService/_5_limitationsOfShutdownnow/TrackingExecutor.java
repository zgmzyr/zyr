/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._2_stoppingAThread_basedService._5_limitationsOfShutdownnow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TrackingExecutor.java $Date: May 23, 2013 1:46:15 PM -0400 2013
 * @since 1.0
 * 
 */
public class TrackingExecutor extends AbstractExecutorService {
	private final ExecutorService exec; 
	private final Set<Runnable> tasksCancelledAtShutdown = Collections.synchronizedSet(new HashSet<Runnable>());
	
	public TrackingExecutor(ExecutorService exec) {
		super();
		this.exec = exec;
	}


	public List<Runnable> getCancelledTasks() {
        if (!exec.isTerminated()) {
        	throw new IllegalStateException("状态不合法");
        }
        
        return new ArrayList<Runnable>(tasksCancelledAtShutdown);
    }

	@Override
	public void execute(final Runnable runnable) {
		exec.execute(new Runnable() {
			public void run() {
				try {
					runnable.run();
					//TODO 在此,存在误报的可能，因存在一个竞态条件：在任务执行最后一条指令与线程池将任务标记为“结束”的两个时刻之间，线程池
					//可能会被关闭。视具体情况看是否要进行考虑
				} finally {
					//TODO 放在catch块中是否更加好一点？
					if (isShutdown() && Thread.currentThread().isInterrupted())
						tasksCancelledAtShutdown.add(runnable);
				}
			}
		});
	}

	@Override
	public void shutdown() {
		//TODO
		
	}

	@Override
	public List<Runnable> shutdownNow() {
		//TODO
		return null;
	}

	@Override
	public boolean isShutdown() {
		//TODO
		return false;
	}

	@Override
	public boolean isTerminated() {
		//TODO
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		//TODO
		return false;
	}

	// delegate other ExecutorService methods to exec
}
