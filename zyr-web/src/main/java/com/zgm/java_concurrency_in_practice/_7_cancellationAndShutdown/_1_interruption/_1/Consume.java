/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._1_interruption._1;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Consume.java $Date: May 20, 2013 2:37:53 PM -0400 2013
 * @since 1.0
 * 
 */
public class Consume {
	
	void consumePrimes() throws InterruptedException {
//	    BlockingQueue<BigInteger> primes = ...;
	    BlockingQueue<BigInteger> primes = new LinkedBlockingQueue<BigInteger>(); 
	    
	    BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
	    producer.start();
	    
	    try {
	        while (needMorePrimes())
	            consume(primes.take());
	    } finally {
	        producer.cancel();
	    }
	}

	private void consume(BigInteger take) {
		//TODO
		
	}

	private boolean needMorePrimes() {
		//TODO
		return false;
	}

}
