/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._0;

import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SuperClass.java $Date: 2013-4-5 下午8:05:55 -0400 2013
 * @since 1.0
 * 
 */
public class SuperClass {

	public void method(List<?> param) {
		System.out.println("调用父类中的方法");
	}
}
