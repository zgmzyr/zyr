package com.zgm.test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author zhouguangming
 * 创建时间: 2014年12月30日 上午10:15:20
 */
public class Test3 {

	@Test
	public void test() {
		
		System.out.println((3 % 2) == 1);
		assertTrue(3 % 2 == 1);
	}
}
