/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._3_atomicVariableClasses._1_atomicsAsBetterVolatiles;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CasNumberRange.java $Date: Jun 17, 2013 2:17:19 PM -0400 2013
 * @since 1.0
 * 
 */
public class CasNumberRange {

	private final AtomicReference<IntPair> values = new AtomicReference<IntPair>(new IntPair(0, 0));

	public int getLower() {
		return values.get().lower;
	}

	public int getUpper() {
		return values.get().upper;
	}

	public void setLower(int i) {
		while (true) {
			IntPair oldv = values.get();
			if (i > oldv.upper)
				throw new IllegalArgumentException("Can't set lower to " + i + " > upper");
			IntPair newv = new IntPair(i, oldv.upper);
			if (values.compareAndSet(oldv, newv))
				return;
		}
	}

	// similarly for setUpper

	// @Immutable
	private static class IntPair {
		final int lower; // Invariant: lower <= upper
		final int upper;

		public IntPair(int lower, int upper) {
			this.lower = lower;
			this.upper = upper;

		}
	}
}
