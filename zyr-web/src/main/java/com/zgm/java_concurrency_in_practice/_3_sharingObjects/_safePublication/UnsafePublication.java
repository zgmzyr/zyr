/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._safePublication;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: UnsafePublication.java $Date: Apr 16, 2013 2:37:30 PM -0400 2013
 * @since 1.0
 * 
 */
//不安全的发布
public class UnsafePublication {
	public Holder holder;
	
	public void initialize() {
	    holder = new Holder(42);
	}
}
