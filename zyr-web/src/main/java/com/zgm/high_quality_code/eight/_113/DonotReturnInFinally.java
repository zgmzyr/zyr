/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._113;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: DonotReturnInFinally.java $Date: 2012-5-9 下午9:38:24 -0400 2012
 * @since 1.0
 * 
 */
public class DonotReturnInFinally {
	public static void main(String[] args) {
		try {
			System.out.println(doStuff(-2));
			System.out.println(doStuff(2));
			
			System.out.println(doStuff2(1));
			
			System.out.println(doStuff3(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int doStuff(int value) throws Exception {
		try {
			if (value < 0) {
				throw new Exception();
			} else {
				return value;
			}
			
		} catch (Exception e) {
			// 异常处理
			
			throw e;
		} finally {
			//1.异常会丢失。 2.返回值被覆盖了 （在finally中出现 return语句，会黄色波浪线的警告信息）
			return -1; 
		}
	}
	
	public static int doStuff2(int value) throws Exception {
		try {
			return value;
			
		} catch (Exception e) {
			// 异常处理
			
			throw e;
		} finally {
			value = 3; 
		}
		
//		return 0;
	}
	
	public static StringBuilder doStuff3(int value) throws Exception {
		StringBuilder sb = new StringBuilder();
				
		try {
			sb.append(value);
			return sb;
		} catch (Exception e) {
			// 异常处理
			
			throw e;
		} finally {
			sb.append(3); 
		}
		
//		return 0;
	}
}
