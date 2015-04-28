package com.zgm.java.lang.String;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年7月1日 上午11:44:06
 */
public class SplitTest {

	@Test
	public void split() {
		String str0 = "cn";
		assertTrue(str0.split("\\.")[0].equals("cn"));
		
		String str1 = "xxx.com.cn";
		assertTrue(str1.split("\\.").length == 3);
	}
}
