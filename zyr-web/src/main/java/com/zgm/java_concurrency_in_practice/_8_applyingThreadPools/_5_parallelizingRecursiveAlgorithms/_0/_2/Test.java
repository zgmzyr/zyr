/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._2;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 24, 2013 3:05:59 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	public <T> void sequentialRecursive(List<Node<T>> nodes, Collection<T> results) {
		for (Node<T> n : nodes) {
			results.add(n.compute());
			sequentialRecursive(n.getChildren(), results);
		}
	}

	//Transforming Sequential Tail-recursion into Parallelized Recursion
	public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, final Collection<T> results) {
		for (final Node<T> n : nodes) {
			exec.execute(new Runnable() {
				public void run() {
					results.add(n.compute());
				}
			});
			parallelRecursive(exec, n.getChildren(), results);
		}
	}

	//Waiting for Results to be Calculated in Parallel
	public <T> Collection<T> getParallelResults(List<Node<T>> nodes) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Queue<T> resultQueue = new ConcurrentLinkedQueue<T>();
		parallelRecursive(exec, nodes, resultQueue);
		exec.shutdown();
		exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		
		return resultQueue;
	}

}
