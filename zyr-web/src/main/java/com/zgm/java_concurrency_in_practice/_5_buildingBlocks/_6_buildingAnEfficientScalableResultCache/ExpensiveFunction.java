/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._6_buildingAnEfficientScalableResultCache;

import java.math.BigInteger;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ExpensiveFunction.java $Date: May 17, 2013 9:42:33 AM -0400 2013
 * @since 1.0
 * 
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

	@Override
	public BigInteger compute(String arg) throws InterruptedException {
		//TODO
		return null;
	}

}
