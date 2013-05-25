/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._safePublication;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Holder.java $Date: Apr 16, 2013 2:38:45 PM -0400 2013
 * @since 1.0
 * 
 */
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) //TODO
            throw new AssertionError("This statement is false.");
    }
}
