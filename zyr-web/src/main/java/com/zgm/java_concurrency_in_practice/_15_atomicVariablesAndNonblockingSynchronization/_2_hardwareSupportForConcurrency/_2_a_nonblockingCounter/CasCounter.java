/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._2_hardwareSupportForConcurrency._2_a_nonblockingCounter;

import com.zgm.java_concurrency_in_practice._15_atomicVariablesAndNonblockingSynchronization._2_hardwareSupportForConcurrency._1_compareAndSwap.SimulatedCAS;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CasCounter.java $Date: Jun 17, 2013 10:16:50 AM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class CasCounter {
	private SimulatedCAS value;

	public int getValue() {
		return value.get();
	}

	public int increment() {
		int v;
		do {
			v = value.get();
		} while (v != value.compareAndSwap(v, v + 1));
		
		return v + 1;
	}
}
