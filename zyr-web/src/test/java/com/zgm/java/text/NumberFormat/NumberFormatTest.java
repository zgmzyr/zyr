package com.zgm.java.text.NumberFormat;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

public class NumberFormatTest {

	
	
	@Test
	public void testA() {
		String a1 = getPercentage(new BigDecimal("-2.34445"), 2);
		assertEquals("-234.44%", a1);

		String a2 = getPercentage(new BigDecimal("2.34445"), 2);
		assertEquals("+234.44%", a2);
	}

	private String getPercentage(Number obj, int scale) {
		NumberFormat nf = NumberFormat.getPercentInstance();
		//设置百分数精确度2即保留两位小数
		
		nf.setMinimumFractionDigits(scale);
		String increaseStr = nf.format(obj);
		if (new BigDecimal(String.valueOf(obj.doubleValue())).compareTo(BigDecimal.ZERO) > 0) {
			return "+" + increaseStr;
		} 
		
		return increaseStr;
	}
	
	@Test
	public void test() {
		System.out.println(getTwo(4.1));
		System.out.println(getTwo(4.111));
		System.out.println(getTwo(4.110));
		System.out.println(getTwo(4.100));
		System.out.println(getTwo(4));
		System.out.println(getTwo(4.320));
		System.out.println(getTwo(4444.325));
		System.out.println(getTwo(4444.324));
		System.out.println(getTwo(0.324));
//		System.out.println(getTwo("abc"));
	}
	
	@Test
	public void test2() {
		System.out.println(getForScale(4.1, 2));
		System.out.println(getForScale(4.111, 2));
		System.out.println(getForScale(4.110, 2));
		System.out.println(getForScale(4.100, 2));
		System.out.println(getForScale(4, 2));
		System.out.println(getForScale(4.320, 2));
		System.out.println(getForScale(4444.325, 2));
		System.out.println(getForScale(4444.324, 2));
		
		System.out.println(getForScale(4444.324, 0));
		System.out.println(getForScale(0.324, 2));

	}
	
	@Test
	public void test3() {
		System.out.println(getForScale2(4.1, 2));
		System.out.println(getForScale2(4.111, 2));
		System.out.println(getForScale2(4.110, 2));
		System.out.println(getForScale2(4.100, 2));
//		System.out.println(getForScale2(4, 2));  //如果是整数,会报错,　FIXME
		System.out.println(getForScale2(4.320, 2));
		System.out.println(getForScale2(4444.325, 2));
		System.out.println(getForScale2(4444.324, 2));
	}
	
	@Test
	public void test4() {
		assertEquals("9999.25", formatStr(new BigDecimal("9999.246"), 2));
		assertEquals("10.00万", formatStr(new BigDecimal("99999.256"), 2));
		assertEquals("2.00亿", formatStr(new BigDecimal("199999999.256"), 2));
		assertEquals("10.00亿", formatStr(new BigDecimal("999999999.256"), 2));
	}
	
	private String formatStr(BigDecimal number, int scale) {
		if (number == null) {
			return "";
		}
		BigDecimal oneHundredMillion = new BigDecimal("100000000");
		BigDecimal tenThousand = new BigDecimal("10000");
		if (number.compareTo(tenThousand) < 0) {
			return getForScale(number, scale);
		} else if (number.compareTo(tenThousand) >= 0 && number.compareTo(oneHundredMillion) < 0) {
			return getForScale(number.divide(tenThousand, 2, BigDecimal.ROUND_HALF_UP), 2) + "万";
		} else {
			return getForScale(number.divide(oneHundredMillion, 2, BigDecimal.ROUND_HALF_UP), 2) + "亿";
		}
	}
	
	private String getTwo(Number number) {
	/*	NumberFormat nf = NumberFormat.getPercentInstance();
		//设置百分数精确度2即保留两位小数
//		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2)
		return nf.format(obj);
		*/;
		
//		DecimalFormat df = new java.text.DecimalFormat("#.00"); //当小于1时会省略整数０
		DecimalFormat df = new java.text.DecimalFormat("#0.00");
		return df.format(number);

	}
	
	//直接舍去后面位
	private String getForScale(Number number, int scale) {
		StringBuilder pattern;
		if (scale <= 0) {  //FIXME
			pattern = new StringBuilder("#0");
		} else {
			pattern = new StringBuilder("#0.");
		}
		
		for (int i = 0; i < scale; i++) {
			pattern.append("0");
		}
		
		DecimalFormat df = new java.text.DecimalFormat(pattern.toString());
		return df.format(number);
	}
	
	private String getForScale2(Number number, int scale) {
//		assertEquals("1.53", String.format("%.2f", d))
		return String.format("%." + scale + "f", number);
	}
}
