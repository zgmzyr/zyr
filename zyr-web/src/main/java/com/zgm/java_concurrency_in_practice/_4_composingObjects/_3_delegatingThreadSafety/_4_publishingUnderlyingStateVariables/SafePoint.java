/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._3_delegatingThreadSafety._4_publishingUnderlyingStateVariables;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SafePoint.java $Date: Apr 17, 2013 3:05:34 PM -0400 2013
 * @since 1.0
 * 
 */
//@ThreadSafe
public class SafePoint {
//    @GuardedBy("this")
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
//    	this(p.x, p.y); //会产生竞态条件，（没有同步，可见性得不到保证）
    }
    
    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
