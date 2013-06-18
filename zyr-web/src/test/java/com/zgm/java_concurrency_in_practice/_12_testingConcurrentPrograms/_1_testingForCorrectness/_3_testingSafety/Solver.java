/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._12_testingConcurrentPrograms._1_testingForCorrectness._3_testingSafety;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Solver.java $Date: May 29, 2013 3:11:39 PM -0400 2013
 * @since 1.0
 * 
 */
class Solver {
	final int N;
	final float[][] data;
	final CyclicBarrier barrier;

	class Worker implements Runnable {
		int myRow;

		Worker(int row) {
			myRow = row;
		}

		public void run() {
			while (!done()) {
				processRow(myRow);

				try {
					barrier.await();
				} catch (InterruptedException ex) {
					return;
				} catch (BrokenBarrierException ex) {
					return;
				}
			}
		}

		private void processRow(int myRow2) {
			// TODO

		}

		private boolean done() {
			// TODO
			return false;
		}
	}

	public Solver(float[][] matrix) {
		data = matrix;
		N = matrix.length;
		barrier = new CyclicBarrier(N, new Runnable() {
			public void run() {
				mergeRows();
			}

			private void mergeRows() {
				// TODO

			}
		});
		for (int i = 0; i < N; ++i)
			new Thread(new Worker(i)).start();

		waitUntilDone();
	}

	private void waitUntilDone() {
		// TODO

	}
}
