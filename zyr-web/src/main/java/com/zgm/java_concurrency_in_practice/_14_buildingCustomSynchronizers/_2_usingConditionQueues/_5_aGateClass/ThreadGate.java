/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._2_usingConditionQueues._5_aGateClass;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ThreadGate.java $Date: Jun 13, 2013 2:42:20 PM -0400 2013
 * @since 1.0
 * 
 */
//@ThreadSafe
public class ThreadGate {
    // CONDITION-PREDICATE: opened-since(n) (isOpen || generation>n)
//    @GuardedBy("this")
    private boolean isOpen;
//    @GuardedBy("this")
    private int generation;

    public synchronized void close() {
        isOpen = false;
    }

    public synchronized void open() {
        ++generation;
        isOpen = true;
        notifyAll();
    }

    // BLOCKS-UNTIL: opened-since(generation on entry)
    public synchronized void await() throws InterruptedException {
		int arrivalGeneration = generation;
		//TODO
        while (!isOpen && arrivalGeneration == generation)
            wait();
    }
}



