/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._4_addingFunctionalityToExistingThreadSafeClasses._0;

import java.util.Vector;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BetterVector.java $Date: May 14, 2013 3:11:31 PM -0400 2013
 * @param <E>
 * @since 1.0
 * 
 */
//@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    private static final long serialVersionUID = 2867565908517437313L;

	public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent)
            add(x);
        
        return absent;
    }
}
