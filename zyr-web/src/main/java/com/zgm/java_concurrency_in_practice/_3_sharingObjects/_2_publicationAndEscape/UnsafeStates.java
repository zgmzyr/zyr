/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._2_publicationAndEscape;

/**
 * 使内部的可变状态逸出 (不要这么做)
 * 
 * @author 周光明 Exp
 * @version $FileName: UnsafeStates.java $Date: Apr 15, 2013 2:41:49 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class UnsafeStates {
	private String[] states = new String[] { "AK", "AL" /* ... */
	};

	public String[] getStates() {
		return states;
	}
}
