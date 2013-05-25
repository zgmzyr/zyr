/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PrimeGenerator.java $Date: May 20, 2013 2:06:05 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class PrimeGenerator implements Runnable {
	// @GuardedBy("this")
	private final List<BigInteger> primes = new ArrayList<BigInteger>();
	private volatile boolean cancelled;

	public void run() {
		BigInteger p = BigInteger.ONE;
		while (!cancelled) {
			p = p.nextProbablePrime();
			synchronized (this) {
				primes.add(p);
			}
		}
	}

	public void cancel() {
		cancelled = true;
	}

	public synchronized List<BigInteger> get() {
		return new ArrayList<BigInteger>(primes);
	}
}
