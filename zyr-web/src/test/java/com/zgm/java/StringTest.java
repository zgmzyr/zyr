/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java;

import org.junit.Test;

/**
 * @author 周光明
 * @File StringTest.java Date: Dec 10, 201310:24:00 AM-0400 2013
 * @since 1.0
 */
public class StringTest {

	@Test
	public void split() {
		String value = "1,2,3,4,5,6#17";
		String[] split = value.split(",|#");
		System.out.println(split);
	}
	
	/**
	 * 补零或者去零测试
	 */
	@Test
	public void fillOrFall() {
		String str = "1";
		//补空格
		System.out.println(String.format("%6s", str));
		//补零
		System.out.println(String.format("%06d", Integer.parseInt(str)));
		
		//去零
		String str2 = "0050580";
		System.out.println(str2.replaceFirst("^0*", ""));
	}
}
