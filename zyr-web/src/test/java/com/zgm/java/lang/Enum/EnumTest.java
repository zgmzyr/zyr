package com.zgm.java.lang.Enum;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author zhouguangming 创建时间: 2014年7月8日 下午5:24:15
 */
public class EnumTest {

	@Test
	public void test() {
		assertTrue(Season.SPRING.getIndex() == 1);
		
		Season season = Season.SPRING;
		Season.SPRING.setIndex(11);
		assertTrue(Season.SPRING.getIndex() == 11);
		
		assertTrue(Season.SPRING == season);
	}
}

enum Season {
	SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
	
	private Season(int index) {
		this.index = index;
	}
	
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}