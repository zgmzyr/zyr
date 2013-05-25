/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._6_buildingAnEfficientScalableResultCache;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Memoizer1.java $Date: May 17, 2013 9:44:52 AM -0400 2013
 * @since 1.0
 * 
 */
public class Memoizer1<A, V> implements Computable<A, V> {
//    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
