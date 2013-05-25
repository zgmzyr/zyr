/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._2_stoppingAThread_basedService._5_limitationsOfShutdownnow;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: WebCrawler.java $Date: May 23, 2013 2:09:07 PM -0400 2013
 * @since 1.0
 * 
 */
public abstract class WebCrawler {
	private static final long TIMEOUT = 0;
	private static final TimeUnit UNIT = TimeUnit.SECONDS;

	private volatile TrackingExecutor exec;
	// @GuardedBy("this")
	private final Set<URL> urlsToCrawl = new HashSet<URL>();

	// ...
	public synchronized void start() {
		exec = new TrackingExecutor(Executors.newCachedThreadPool());
		
		for (URL url : urlsToCrawl) {
			submitCrawlTask(url);
		}
		
		urlsToCrawl.clear();
	}

	public synchronized void stop() throws InterruptedException {
		try {
			saveUncrawled(exec.shutdownNow());
			if (exec.awaitTermination(TIMEOUT, UNIT))
				saveUncrawled(exec.getCancelledTasks());
		} finally {
			//TODO
			exec = null;
		}
	}

	protected abstract List<URL> processPage(URL url);

	private void saveUncrawled(List<Runnable> uncrawled) {
		for (Runnable task : uncrawled)
			urlsToCrawl.add(((CrawlTask) task).getPage());
	}

	private void submitCrawlTask(URL u) {
		exec.execute(new CrawlTask(u));
	}

	private class CrawlTask implements Runnable {
		private final URL url;

		public CrawlTask(URL url) {
			this.url = url;
		}

		// ...
		public void run() {
			for (URL link : processPage(url)) {
				if (Thread.currentThread().isInterrupted())
					return;
				
				submitCrawlTask(link);
			}
		}

		public URL getPage() {
			return url;
		}
	}
}
