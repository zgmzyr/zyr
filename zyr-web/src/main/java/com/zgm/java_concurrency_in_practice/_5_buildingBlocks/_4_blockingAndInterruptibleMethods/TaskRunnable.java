/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._4_blockingAndInterruptibleMethods;

import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TaskRunnable.java $Date: May 16, 2013 9:35:43 AM -0400 2013
 * @since 1.0
 * 
 */
public class TaskRunnable implements Runnable {
    BlockingQueue<Task> queue;
    
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
             // restore interrupted status
        	//防止中断信息丢失
             Thread.currentThread().interrupt();
        }
    }

	private void processTask(Task take) {
		//TODO
		
	}
}

