/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._1_typeSignature._3_superIsGenericButSubIsNotGeneric;
/**
 * GenericSuperClass<T>类型擦除后的类型, 相应的其子类会生成一个桥接方法
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericSuperClass2.java $Date: 2013-4-10 下午8:41:00 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSuperClass2 { //当然真正探险后应该是GenericSuperClass
	
	public void method(Object obj) {
		System.out.println("父类的方法：" + obj);
	}
}
