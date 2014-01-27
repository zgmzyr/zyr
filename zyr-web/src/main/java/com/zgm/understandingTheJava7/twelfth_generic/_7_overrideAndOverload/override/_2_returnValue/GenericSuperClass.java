/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._2_returnValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericSuperClass.java $Date: 2013-4-12 下午8:54:21 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSuperClass<T> {

	public List<? extends Serializable> method() {
		System.out.println("父类中的方法");
//		return null;
//		return new ArrayList<Integer>();
//		return new ArrayList<>();
		return new ArrayList<Number>();
	}
}
