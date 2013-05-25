/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._2_thread_safety._3_locking._1_intrinsicLocks;

import java.math.BigInteger;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SynchronizedFactorizer.java $Date: Apr 12, 2013 11:19:58 AM -0400 2013
 * @since 1.0
 * 
 */
//@ThreadSafe
public class SynchronizedFactorizer extends GenericServlet implements Servlet {
//    @GuardedBy("this") 
    private BigInteger lastNumber;
//    @GuardedBy("this") 
    private BigInteger[] lastFactors;

    public synchronized void service(ServletRequest req,
                                     ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        if (i.equals(lastNumber))
            encodeIntoResponse(resp, lastFactors);
        else {
            BigInteger[] factors = factor(i);
            lastNumber = i;
            lastFactors = factors;
            encodeIntoResponse(resp, factors);
        }
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
}
