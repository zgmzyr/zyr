/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._1_implicitCouplingsBetweenTasksAndExecutionPolicies._1_threadStarvationDeadlock;

import java.util.concurrent.Callable;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LoadFileTask.java $Date: May 24, 2013 10:21:22 AM -0400 2013
 * @since 1.0
 * 
 */
public class LoadFileTask implements Callable<String> {

	public LoadFileTask(String string) {
	}

	@Override
	public String call() throws Exception {
		//TODO
		return null;
	}

}
