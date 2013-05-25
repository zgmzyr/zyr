/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._4_immutability._1_finalFilds;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FinalTest.java $Date: Apr 16, 2013 3:58:49 PM -0400 2013
 * @since 1.0
 * 
 */
public class FinalTest {
	
	private final int a;
//	private final int a = 1;
	
	public FinalTest(int a) {
		super();
		this.a = a;
	}
	
	public FinalTest() {
		this.a = 1;
	}
}
