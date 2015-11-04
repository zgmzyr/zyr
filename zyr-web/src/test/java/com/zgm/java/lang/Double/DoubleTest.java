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
	
	//double四舍五入并保留两位小数的方法
	@Test
	public void test() {
		//http://blog.csdn.net/huaishuming/article/details/17752365
		double d = 1.5255;
		System.out.println(String.format("%.2f", d));
		assertEquals("1.53", String.format("%.2f", d));

		System.out.println(String.format("%.3f", d));
		assertEquals("1.526", String.format("%.3f", d));
	}
}
