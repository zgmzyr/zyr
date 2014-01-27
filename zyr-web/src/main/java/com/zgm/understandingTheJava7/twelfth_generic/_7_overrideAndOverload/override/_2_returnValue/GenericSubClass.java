/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._7_overrideAndOverload.override._2_returnValue;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GenericSubClass.java $Date: 2013-4-12 下午9:01:22 -0400 2013
 * @since 1.0
 * 
 */
public class GenericSubClass<S extends Number> extends GenericSuperClass<S> {

/*	
    //不能与public List<S> method() 共存
	@Override
	public List<? extends Serializable> method() {
		//TODO
		return super.method();
	}
*/
	
	@Override
	public List<Number> method() {
		System.out.println("子类中的方法");
		return null;
	}
/*	
	@Override
	public List<S> method() {
		return null;
	}*/
	
	public static void main(String[] args) {
		GenericSuperClass<Number> sub = new GenericSubClass<>();
//		List<Serializable> list1 = sub.method(); //编译错误
//		List<Integer> list2 = sub.method(); //编译错误
//		List<? extends Number> list5 = sub.method(); //编译错误
		List<? extends Serializable> list3 = sub.method();
		List<? extends Object> list4 = sub.method();
		List<?> list5 = sub.method();
	}
}
