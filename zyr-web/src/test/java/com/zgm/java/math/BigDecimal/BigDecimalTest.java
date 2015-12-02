package com.zgm.java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {

	@Test
	public void test() {
		Integer a = 2;
		assertEquals("2", a.toString());

		BigDecimal b = new BigDecimal(2);
		assertEquals("2", b.toString());

		BigDecimal c = new BigDecimal(2.1);
//		assertEquals("2.1", c.toString());

		BigDecimal d = new BigDecimal("2.1");
		assertEquals("2.1", d.toString());
		
		
	}
}
