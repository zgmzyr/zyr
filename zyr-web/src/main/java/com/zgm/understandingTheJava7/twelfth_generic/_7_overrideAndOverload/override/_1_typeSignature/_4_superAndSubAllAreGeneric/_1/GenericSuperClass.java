/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._4_superAndSubAllAreGeneric._1;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericSuperClass.java $Date: 2013-4-11 下午8:34:31 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSuperClass<T> {
	
	//使用泛形类的形式参数
	public void method(T obj) {
		System.out.println("父类的方法：" + obj);
	}

}
