/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.test.interface_test;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Jun 14, 2013 9:42:01 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test implements SuperAA, SuperA {

	@Override
	public void a() {
		//TODO
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		new Test().a();
	}

}
