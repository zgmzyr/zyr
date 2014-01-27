/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BigDecimalTest.java $Date: Sep 27, 2013 5:27:06 PM -0400 2013
 * @since 1.0
 * 
 */
public class BigDecimalTest {

	@Test
	public void test0() {
		BigDecimal valueOf = new BigDecimal("50.12");
		System.out.println(valueOf.toString());
		BigDecimal inpriceTemp = valueOf.multiply(new BigDecimal(100));
		System.out.println(inpriceTemp.intValue());
		
		double d = Double.parseDouble("50.12");
		System.out.println(d);
		
		int i = (int) (d * 100);
		System.out.println(i);
		
		
	}
	
	@Test
	public void test1() {
		BigDecimal b1 = BigDecimal.ZERO;
		BigDecimal b2 = b1.add(new BigDecimal(2));

		System.out.println(b1.intValue());
		System.out.println(b2.intValue());
	}

	@Test
	public void test2() {
		double aDouble = 1.22;
		System.out.println("Double.toString(): " + Double.toString(aDouble));
		BigDecimal aBigDecimalFormDouble = new BigDecimal(aDouble);
		System.out.println("construct with a double value: " + aBigDecimalFormDouble);
		System.out.println("转换字符串后，再: " + new BigDecimal(String.valueOf(aDouble)));

		BigDecimal aBigDecimalFormString = new BigDecimal("1.22");
		System.out.println("construct with a String value: " + aBigDecimalFormString);
	}

	@Test
	public void add() {
		BigDecimal a = new BigDecimal("1.22");
		System.out.println("construct with a String value: " + a);
		BigDecimal b = new BigDecimal("2.22");
		BigDecimal result = a.add(b);
		System.out.println("aplus b is : " + a);
		System.out.println("a aplus b is : " + result);
	}

	@Test
	public void construct() {
		BigDecimal b1 = new BigDecimal("9.111");
		System.out.println(" b1: " + b1); // b1: 9.111
		System.out.println(" b1: 变形：" + b1.intValue());// b1: 变形：9

		BigDecimal b2 = new BigDecimal(9.111d);
		System.out.println(" b2: " + b2); // b2: 9.111000000000000653699316899292171001434326171875
		System.out.println(" b2: 变形：" + b2.doubleValue()); // b2: 变形：9.111

		BigDecimal b3 = new BigDecimal(9);
		System.out.println(" b3: " + b3); // b3: 9
		System.out.println(" b3: 变形：" + b3.intValue());// b3: 变形：9

		BigDecimal b4 = new BigDecimal(9.111f);
		System.out.println(" b4: " + b4);// b4: 9.11100006103515625
		System.out.println(" b4: 变形：" + b4.floatValue()); // b4: 变形：9.111

		BigDecimal b5 = new BigDecimal(900L);
		System.out.println(" b5: " + b5); // b5: 900
		System.out.println(" b5: 变形：" + b5.longValue());// b5: 变形：900
	}

	@Test
	public void add2() {
		double r1 = add(1.1, 2.9912);
		System.out.println(" r1 : " + r1); // r1 : 4.0912
	}

	@Test
	public void sub() {
		double r3 = sub(2.002, 0.112);
		System.out.println(" r3: " + r3); // r3: 1.89

		double r4 = 2.002 - 0.112;
		System.out.println(" r4: " + r4);// r4: 1.8899999999999997
	}

	/**
	 * 3.精确乘法运算
	 */
	@Test
	public void mul() {
		double r5 = mul(2.002, 1.001);
		System.out.println(" r5: " + r5);// r5: 2.004002

		double r6 = 2.002 * 1.001;
		System.out.println(" r6: " + r6);// r6: 2.0040019999999994

	}

	/**
	 * 4.提供相对精确的除法运算
	 */
	@Test
	public void div() {
		double r7 = div(3.4, 0.055, 2);
		System.out.println(" r7: " + r7); // r7: 61.82

		double r8 = 3.4 / 0.055;
		System.out.println(" r8: " + r8);// r8: 61.81818181818181
	}

	/**
	 * 5.四舍五入处理
	 */
	@Test
	public void roundHalfUp() {
		double s1 = roundHalfUp(2.12512, 3);
		System.out.println(" s1: " + s1);// s1: 2.125

		double s2 = roundHalfUp(2.12512, 2);
		System.out.println(" s2: " + s2);// s2: 2.13
	}

	/**
	 * 提供精确的加法运算 ******************* *******************
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		double result = b1.add(b2).doubleValue();
		return result;
	}

	/**
	 * 提供精确的减法运算 ******************* *******************
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算 ******************* *******************
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的乘机
	 */
	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入 ******************* *******************
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示要精确到小数点后几位
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数四舍五入处理 ******************* *******************
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double roundHalfUp(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
