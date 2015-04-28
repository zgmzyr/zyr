package com.zgm.java.lang.String;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * 创建时间: 2015年2月3日 下午5:01:47
 */
public class EmptyStringTest {

	
	@Test
	public void empty() {
		String empty1 = "";
		String empty2 = "";
		String empty3 = new String("");
		String empty4 = empty3.intern();
		
		assertTrue(empty1 == empty2);
		assertTrue(empty1 != empty3);
		assertTrue(empty1 == empty4);
	}
	
	@Test
	public void test() {
		String str1 = "zyr";
		String str2 = "zyr";
		String str3= new String("zyr");
		String str4= str3.intern();
		
		assertTrue(str1 == str2);
		assertTrue(str1 != str3);
		assertTrue(str1 == str4);
	}
}
