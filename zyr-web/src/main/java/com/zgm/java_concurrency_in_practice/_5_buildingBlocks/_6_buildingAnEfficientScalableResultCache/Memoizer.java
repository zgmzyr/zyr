/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._6_buildingAnEfficientScalableResultCache;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Memoizer.java $Date: May 17, 2013 10:04:40 AM -0400 2013
 * @since 1.0
 * 
 */
public class Memoizer<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> cache
        = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) { this.c = c; }

    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {
                    public V call() throws InterruptedException {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) { f = ft; ft.run(); }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
            }
        }
    }
    
    /**
  	 * If the Throwable is an Error, throw it; if it is a RuntimeException return it, otherwise throw
  	 * IllegalStateException
  	 */
  	public static RuntimeException launderThrowable(Throwable t) {
  		if (t instanceof RuntimeException)
  			return (RuntimeException) t;
  		else if (t instanceof Error)
  			throw (Error) t;
  		else
  			throw new IllegalStateException("Not unchecked", t);
  	} 
}



