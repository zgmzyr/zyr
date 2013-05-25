/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._4_immutability._2_usingVolatileToPublishImmutableObjects;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: OneValueCache.java $Date: Apr 16, 2013 2:08:18 PM -0400 2013
 * @since 1.0
 * 
 */
//@Immutable  //不可变的
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,
                         BigInteger[] factors) {
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i))
            return null;
        else
            return Arrays.copyOf(lastFactors, lastFactors.length);
    }
}
