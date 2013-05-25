/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._2_parallel;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

import com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._3_aPuzzleFramework._1_sequential.Puzzle;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ConcurrentPuzzleSolver.java $Date: May 24, 2013 3:28:37 PM -0400 2013
 * @since 1.0
 * 
 */
public class ConcurrentPuzzleSolver<P, M> {
	private final Puzzle<P, M> puzzle;
	private final ExecutorService exec;
	private final ConcurrentMap<P, Boolean> seen;
	private final ValueLatch<Node<P, M>> solution = new ValueLatch<Node<P, M>>();
	
	public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle, ExecutorService exec, ConcurrentMap<P, Boolean> seen) {
		super();
		this.puzzle = puzzle;
		this.exec = exec;
		this.seen = seen;
	}

	// ...
	public List<M> solve() throws InterruptedException {
		try {
			P p = puzzle.initialPosition();
			exec.execute(newTask(p, null, null));
			// block until solution found
			Node<P, M> solnNode = getSolution().getValue();
			return (solnNode == null) ? null : solnNode.asMoveList();
		} finally {
			exec.shutdown();
		}
	}

	protected Runnable newTask(P p, M m, Node<P, M> n) {
		return new SolverTask(p, m, n);
	}

	public ValueLatch<Node<P, M>> getSolution() {
		return solution;
	}

	protected class SolverTask extends Node<P, M> implements Runnable {
		public SolverTask(P p, M m, Node<P, M> n) {
			super(p, m, n);
		}

		// ...
		public void run() {
			if (getSolution().isSet() || seen.putIfAbsent(pos, true) != null)
				return; // already solved or seen this position
			if (puzzle.isGoal(pos))
				getSolution().setValue(this);
			else
				for (M m : puzzle.legalMoves(pos))
					exec.execute(newTask(puzzle.move(pos, m), m, this));
		}
	}

	// @Immutable
	public static class Node<P, M> {
		final P pos;
		final M move;
		final Node<P, M> prev;

		Node(P pos, M move, Node<P, M> prev) {
			this.pos = pos;
			this.move = move;
			this.prev = prev;

			// ...
		}

		List<M> asMoveList() {
			List<M> solution = new LinkedList<M>();
			for (Node<P, M> n = this; n.move != null; n = n.prev)
				solution.add(0, n.move);
			return solution;
		}
	}
}
