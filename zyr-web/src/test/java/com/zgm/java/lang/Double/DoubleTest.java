package com.zgm.java.lang.Double;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleTest {

	
	@Test
	public void compare() {
//		double a = 0.1;
//		double b = 0.1;
		double a = 99.0123456789123456789d;
//		double b = 99.0123456789123456788d; //最后是8
		double b = 99.0123456789123456789222222222222222222222222222222222222222222222222222222d;
		
		assertTrue(a == b);
		assertTrue(a < b); //fasle 被截取了
		
//		14位后面的都被截取掉
		System.out.println("a: " + String.valueOf(a));// 99.01234567891234

		double c = 99999.0123456789123456789d;
		System.out.println("c: " + String.valueOf(c));// 99999.01234567892
	}
}
