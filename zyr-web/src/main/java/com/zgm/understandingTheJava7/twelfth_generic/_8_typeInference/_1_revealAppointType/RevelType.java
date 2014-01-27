/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._8_typeInference._1_revealAppointType;

import java.io.Serializable;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: RevelType.java $Date: 2013-4-14 上午10:05:52 -0400 2013
 * @since 1.0
 * 
 */
public class RevelType {

	public static void main(String[] args) {
		TypeInference ti = new TypeInference();
		ti.<Serializable>method((Serializable) "Hello");
		ti.<String>method("Hello");
//		ti.<String>method((String) 2);
		
		Object obj = "Hello";
//		ti.<String>method(obj);//编译错误
	}
}
