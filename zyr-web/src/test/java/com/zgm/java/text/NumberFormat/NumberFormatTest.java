package com.zgm.java.text.NumberFormat;

import java.text.DecimalFormat;

import org.junit.Test;

public class NumberFormatTest {

	
	@Test
	public void test() {
		System.out.println(getTwo(4.1));
		System.out.println(getTwo(4.111));
		System.out.println(getTwo(4.110));
		System.out.println(getTwo(4.100));
		System.out.println(getTwo(4));
		System.out.println(getTwo(4.320));
		System.out.println(getTwo(4444.320));
//		System.out.println(getTwo("abc"));
	}
	
	private String getTwo(Number number) {
	/*	NumberFormat nf = NumberFormat.getPercentInstance();
		//设置百分数精确度2即保留两位小数
//		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2)
		return nf.format(obj);
		*/;
		
		DecimalFormat df = new java.text.DecimalFormat("#.00");
		return df.format(number);

	}
}
