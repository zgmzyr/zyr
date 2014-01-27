/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._8_typeInference._2_typeInference._1_baseOnRealtype;

import com.zgm.understandingTheJava7.twelfth_generic._8_typeInference._1_revealAppointType.TypeInference;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TypeInference.java $Date: 2013-4-14 上午10:15:48 -0400 2013
 * @since 1.0
 * 
 */
public class BaseOnRealTypeTest {

	public static void main(String[] args) {
		//1.基于实际参数
		TypeInference ti = new TypeInference();
		ti.method("hello");
		
	}
	
	
}
