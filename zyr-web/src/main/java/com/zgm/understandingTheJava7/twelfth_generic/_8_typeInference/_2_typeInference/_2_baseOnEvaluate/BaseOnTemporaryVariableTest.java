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
 * @version $FileName: BaseOnTemporaryVariable.java $Date: 2013-4-14 上午10:33:25 -0400 2013
 * @since 1.0
 * 
 */
public class BaseOnTemporaryVariableTest {

	public static void main(String[] args) {
		TypeInference ti = new TypeInference();
		List<Object> objList = ti.method(ti.createList());
//		List<Integer> objList = ti.method(ti.createList());
		
		List<Integer> integerList = ti.createList();
		List<Integer> integerList2 = ti.method(integerList);
	}
}
