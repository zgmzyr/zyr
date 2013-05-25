/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._3_handlingAbnormalThreadTermination._0._1;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Task.java $Date: May 24, 2013 9:03:24 AM -0400 2013
 * @since 1.0
 * 
 */
public class Task implements Runnable{

	@Override
	public void run() {
	    Throwable thrown = null;
	    try {
	        while (!isInterrupted())
	            runTask(getTaskFromWorkQueue());
	    } catch (Throwable e) {
	        thrown = e;
	    } finally {
	        threadExited(this, thrown);
	    }
	}

	private void runTask(Object taskFromWorkQueue) {
		//TODO
		
	}

	private void threadExited(Task task, Throwable thrown) {
		//TODO
		
	}

	private Object getTaskFromWorkQueue() {
		//TODO
		return null;
	}

	private boolean isInterrupted() {
		//TODO
		return false;
	}
}
