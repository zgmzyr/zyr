/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._4_superAndSubAllAreGeneric._1;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericSubClass.java $Date: 2013-4-11 下午8:37:18 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSubClass<S> extends GenericSuperClass<S> {
	
	public void method(S obj) {
		System.out.println("子类的方法：" + obj);
	}
}
