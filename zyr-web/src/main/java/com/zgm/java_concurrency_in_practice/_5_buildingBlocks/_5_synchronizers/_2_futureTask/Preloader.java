/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._5_synchronizers._2_futureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Preloader.java $Date: May 16, 2013 10:51:03 AM -0400 2013
 * @since 1.0
 * 
 */
public class Preloader {
	private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
		public ProductInfo call() throws DataLoadException {
			return loadProductInfo();
		}

		private ProductInfo loadProductInfo() {
			// TODO
			return null;
		}
	});

	private final Thread thread = new Thread(future);

	public void start() {
		thread.start();
	}

	public ProductInfo get() throws DataLoadException, InterruptedException {
		try {
			return future.get();
		} catch (ExecutionException e) {
			Throwable cause = e.getCause();
			if (cause instanceof DataLoadException)
				throw (DataLoadException) cause;
			else
				throw launderThrowable(cause);
		}
	}

	/**
	 * If the Throwable is an Error, throw it; if it is a RuntimeException return it, otherwise throw
	 * IllegalStateException
	 */
	public static RuntimeException launderThrowable(Throwable t) {
		if (t instanceof RuntimeException)
			return (RuntimeException) t;
		else if (t instanceof Error)
			throw (Error) t;
		else
			throw new IllegalStateException("Not unchecked", t);
	}
}
