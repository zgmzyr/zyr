/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._2_instanceConfinment._1_theJavaMonitorPattern.privateLock;

import com.zgm.java_concurrency_in_practice._2_thread_safety._3_locking._2_reentrancy.Widget;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PrivateLock.java $Date: Apr 16, 2013 5:18:21 PM -0400 2013
 * @since 1.0
 * 
 */
public class PrivateLock {
    private final Object myLock = new Object();
//    @GuardedBy("myLock")
    Widget widget;

    void someMethod() {
        synchronized (myLock) {
            // Access or modify the state of widget
        }
    }
}