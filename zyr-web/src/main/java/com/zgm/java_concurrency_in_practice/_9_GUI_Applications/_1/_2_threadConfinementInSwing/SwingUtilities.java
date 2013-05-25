/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._1._2_threadConfinementInSwing;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SwingUtilities.java $Date: May 25, 2013 9:40:35 AM -0400 2013
 * @since 1.0
 * 
 */
public class SwingUtilities {
	private static final ExecutorService exec = Executors.newSingleThreadExecutor(new SwingThreadFactory());
	private static volatile Thread swingThread;

	private static class SwingThreadFactory implements ThreadFactory {
		public Thread newThread(Runnable r) {
			swingThread = new Thread(r);
			return swingThread;
		}
	}

	public static boolean isEventDispatchThread() {
		return Thread.currentThread() == swingThread;
	}

	public static void invokeLater(Runnable task) {
		exec.execute(task);
	}

	public static void invokeAndWait(Runnable task) throws InterruptedException, InvocationTargetException {
		Future f = exec.submit(task);
		try {
			f.get();
		} catch (ExecutionException e) {
			throw new InvocationTargetException(e);
		}
	}
}
