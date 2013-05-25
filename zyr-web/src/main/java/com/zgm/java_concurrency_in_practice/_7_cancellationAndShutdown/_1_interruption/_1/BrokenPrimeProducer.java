/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._1;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BrokenPrimeProducer.java $Date: May 20, 2013 2:35:00 PM -0400 2013
 * @since 1.0
 * 
 */
class BrokenPrimeProducer extends Thread {
	private final BlockingQueue<BigInteger> queue;
	private volatile boolean cancelled = false;

	BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			while (!cancelled)
				queue.put(p = p.nextProbablePrime());
		} catch (InterruptedException consumed) {
		}
	}

	public void cancel() {
		cancelled = true;
	}
}
