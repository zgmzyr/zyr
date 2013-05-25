/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._3;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._1_sequential.Puzzle;
import com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._2_parallel.ConcurrentPuzzleSolver;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PuzzleSolver.java $Date: May 24, 2013 3:52:20 PM -0400 2013
 * @since 1.0
 * 
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {
	public PuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
		super(puzzle, exec, seen);
	}

	// ...
	private final AtomicInteger taskCount = new AtomicInteger(0);

	protected Runnable newTask(P p, M m, Node<P, M> n) {
		return new CountingSolverTask(p, m, n);
	}

	class CountingSolverTask extends SolverTask {
		CountingSolverTask(P pos, M move, Node<P, M> prev) {
			super(pos, move, prev);
			taskCount.incrementAndGet();
		}

		public void run() {
			try {
				super.run();
			} finally {
				if (taskCount.decrementAndGet() == 0)
					// getSolution().setValue(null);
					PuzzleSolver.super.getSolution().setValue(null);
			}
		}
	}
}
