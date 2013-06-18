/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._2_usingConditionQueues._2_wakingUpTooSoon;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Jun 13, 2013 1:51:17 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	private Object lock;

	void stateDependentMethod() throws InterruptedException {
	    // condition predicate must be guarded by lock
	    synchronized(lock) {
	        while (!conditionPredicate())
	            lock.wait();
	        // object is now in desired state
	    }
	}

	private boolean conditionPredicate() {
		//TODO
		return false;
	}

}
