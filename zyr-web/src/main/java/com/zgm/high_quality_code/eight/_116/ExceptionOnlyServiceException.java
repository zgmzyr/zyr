/*
 * Co
pyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._116;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ExceptionOnlyServiceException.java $Date: 2012-5-12
 *          下午10:23:35 -0400 2012
 * @since 1.0
 * 
 */
public class ExceptionOnlyServiceException {

	public static void main(String[] args) {
//		contain(EnumTest.class, "TEST2");
		System.out.println(contain(EnumTest.class, "TEST0"));
		System.out.println(correctContain(EnumTest.class, "TEST0"));
		System.out.println(correctContain(EnumTest.class, "TEST3"));
	}

	/***
	 * 错误用法
	 * @param c
	 * @param name
	 * @return
	 */
	public static <T extends Enum<T>> boolean contain(Class<T> c, String name) {
		if (c == null) {
			return false;
		}
		boolean result = false;
		try {
			Enum.valueOf(c, name);
			result = true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * 推荐用法 
	 * @param c
	 * @param name
	 * @return
	 */
	public static <T extends Enum<T>> boolean correctContain(Class<T> c, String name) {
		if (c == null) {
			return false;
		}
		for (T t : c.getEnumConstants()) {
			if (t.name().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	private enum EnumTest {
		TEST0, TEST1
	}

}
