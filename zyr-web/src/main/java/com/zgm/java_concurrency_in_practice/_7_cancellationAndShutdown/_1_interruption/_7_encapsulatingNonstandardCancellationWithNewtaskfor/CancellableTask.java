/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._7_encapsulatingNonstandardCancellationWithNewtaskfor;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CancellableTask.java $Date: May 21, 2013 2:20:30 PM -0400 2013
 * @since 1.0
 * 
 */
public interface CancellableTask<T> extends Callable<T> {
	
	void cancel();
	
    RunnableFuture<T> newTask();

}
