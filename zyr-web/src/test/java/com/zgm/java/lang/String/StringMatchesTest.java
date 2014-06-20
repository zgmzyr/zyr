package com.zgm.java.lang.String;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年5月26日 上午11:25:03
 */
public class StringMatchesTest {
	
	@Test
	public void matchs() {
		assertTrue(!"10086123".matches("10086*"));
		assertTrue("10086123".matches("10086\\d*"));
		assertTrue(!"210086123".matches("10086\\d*"));
		assertTrue(!"100846123".matches("10086\\d*"));
	}
}
