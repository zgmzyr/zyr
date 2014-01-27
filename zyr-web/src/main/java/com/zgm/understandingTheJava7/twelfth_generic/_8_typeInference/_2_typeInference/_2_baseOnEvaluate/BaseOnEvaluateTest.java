/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._8_typeInference._2_typeInference._2_baseOnEvaluate;

import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BaseOnEvaluateTest.java $Date: 2013-4-14 上午10:27:13 -0400 2013
 * @since 1.0
 * 
 */
public class BaseOnEvaluateTest {

	public static void main(String[] args) {
		TypeInference ti = new TypeInference();
		List<Integer> integerList = ti.createList();
		List<String> stringList = ti.createList();
	}
}
