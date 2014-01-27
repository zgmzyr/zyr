/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._3_superIsGenericButSubIsNotGeneric;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SubClass.java $Date: 2013-4-9 下午9:18:32 -0400 2013
 * @since 1.0
 * 
 */
public class SubClass0 extends GenericSuperClass {// 继承父类的原始类型，不推荐

//	@Override //加上则编译错误，不加则为重载 
	public void method(Number obj) {
		
	}
	
	@Override
	public void method(Object obj) {
		System.out.println("子类中的方法: " + obj);
	}
}
