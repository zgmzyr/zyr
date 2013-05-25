/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._3_respondingToInterruption;

import java.util.concurrent.BlockingQueue;

import com.zgm.java_concurrency_in_practice._5_buildingBlocks._4_blockingAndInterruptibleMethods.Task;

/**
 *   
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 21, 2013 9:19:01 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {

	//传递异常
	public Task getNextTask1(BlockingQueue<Task> queue) throws InterruptedException {
		return queue.take();
	}

	// 不可取消的任务在退出前恢复中断
	public Task getNextTask2(BlockingQueue<Task> queue) {
		boolean interrupted = false;
		try {
			while (true) {
				try {
					return queue.take();
				} catch (InterruptedException e) {
					interrupted = true;
					// fall through and retry
					
//					Thread.currentThread().interrupt();//TODO 如果在这里恢复中断，会造成死循环
				}
			}
		} finally {
			if (interrupted)
				Thread.currentThread().interrupt();
		}
	}

}
