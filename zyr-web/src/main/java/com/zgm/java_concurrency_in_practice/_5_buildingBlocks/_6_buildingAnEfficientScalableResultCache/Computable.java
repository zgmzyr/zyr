/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._6_buildingAnEfficientScalableResultCache;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Computable.java $Date: May 17, 2013 9:40:24 AM -0400 2013
 * @since 1.0
 * 
 */
public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
