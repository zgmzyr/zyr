/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.six._86;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: EnumTest.java $Date: 2012-5-6 下午9:23:22 -0400 2012
 * @since 1.0
 * 
 */
public class EnumTest {
	public static void main(String[] args) {
		
//		LogLevel logLevel = LogLevel.DEBUG;
		LogLevel logLevel = LogLevel.ERROR;
//		LogLevel logLevel = LogLevel.FATAL_ERROR;
		
		switch(logLevel) {
		case DEBUG :
			System.out.println("debug");
			break;
			
		case INFO :
			System.out.println("INFO");
			break;
		case WARN :
			System.out.println("WARN");
			break;
		case ERROR:
			System.out.println("ERROR");
			break;
		default :
			throw new AssertionError("还有枚举类型没有覆盖！");
		}
	}
	
	private enum LogLevel {
		DEBUG, INFO, WARN, ERROR,
		FATAL_ERROR;
	}
}
