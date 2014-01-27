/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SplitTest.java $Date: Jul 22, 2013 4:42:33 PM -0400 2013
 * @since 1.0
 * 
 */
public class SplitTest {

	@Test
	public void split() {
		String str1 = "aaa,bbb";
		String str2 = "aaa";
		
		assertTrue("失败1", str1.split(",").length == 2);
		assertTrue("失败2", str2.split(",").length == 1);
	}
}
