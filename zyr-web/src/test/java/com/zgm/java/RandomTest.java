/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java;

import java.util.Random;

import org.junit.Test;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: RandomTest.java $Date: Oct 7, 2013 2:14:13 PM -0400 2013
 * @since 1.0
 * 
 */
public class RandomTest {

	@Test
	public void test() {
		Random random = new Random();
		for (int index = 0; index < 1000; index++) {
			int num = random.nextInt(1000);
			System.out.println(num);
		}
	}
}
