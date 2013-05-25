/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._1_implicitCouplingsBetweenTasksAndExecutionPolicies._1_threadStarvationDeadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 不要这么做
 * 
 * @author 周光明 Exp
 * @version $FileName: ThreadDeadlock.java $Date: May 24, 2013 10:20:42 AM -0400 2013
 * @since 1.0
 * 
 */
public class ThreadDeadlock {
	ExecutorService exec = Executors.newSingleThreadExecutor();

	public class RenderPageTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			Future<String> header, footer;
			header = exec.submit(new LoadFileTask("header.html"));
			footer = exec.submit(new LoadFileTask("footer.html"));
			String page = this.renderBody();

			// Will deadlock -- task waiting for result of subtask
			return header.get() + page + footer.get();
		}

		private String renderBody() {
			// TODO
			return null;
		}
	}
}
