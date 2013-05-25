/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._2;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PrimeProducer.java $Date: May 20, 2013 3:25:36 PM -0400 2013
 * @since 1.0
 * 
 */
class PrimeProducer extends Thread {
	private final BlockingQueue<BigInteger> queue;

	PrimeProducer(BlockingQueue<BigInteger> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			BigInteger p = BigInteger.ONE;
			//注：不一定需要在用循环检查中断，因queue.put可以响应中断，但在循环中检查能提高中断的响应性
			while (!Thread.currentThread().isInterrupted()) {
				//TODO 其它操作
				
				queue.put(p = p.nextProbablePrime());
				
				//TODO 其它操作
			}
				
		} catch (InterruptedException consumed) {
			/* Allow thread to exit */
		}
	}

	public void cancel() {
		interrupt();
	}
}
