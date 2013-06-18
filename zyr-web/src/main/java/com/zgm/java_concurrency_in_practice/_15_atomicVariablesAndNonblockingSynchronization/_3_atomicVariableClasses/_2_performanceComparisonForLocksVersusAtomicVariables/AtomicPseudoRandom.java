/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._3_atomicVariableClasses._2_performanceComparisonForLocksVersusAtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: AtomicPseudoRandom.java $Date: Jun 17, 2013 2:30:17 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class AtomicPseudoRandom extends PseudoRandom {
	private AtomicInteger seed;

	AtomicPseudoRandom(int seed) {
		this.seed = new AtomicInteger(seed);
	}

	public int nextInt(int n) {
		while (true) {
			int s = seed.get();
			int nextSeed = super.calculateNext(s);
			if (seed.compareAndSet(s, nextSeed)) {
				int remainder = s % n;
				return remainder > 0 ? remainder : remainder + n;
			}
		}
	}
}
