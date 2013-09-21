/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._4_wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Wildcard.java $Date: 2013-4-4 下午8:54:28 -0400 2013
 * @since 1.0
 * 
 */
public class Wildcard {
	public List<? extends Number> createList() {
//		return new ArrayList<Integer>();
		
		List<Number> list;
		ArrayList<Number> arrayList = new ArrayList<>();
		list = arrayList;
		ArrayList<Integer> arrayList2 = new ArrayList<>();
//		arrayList = arrayList2; //编译错误
//		List<Number> list = new ArrayList<Integer>(); //编译错误
//		List<Number> list = new ArrayList<>();
		
		return new ArrayList<>();
	}
	
	public void use() {
//		List<String> list = this.createList(); //编译错误
//		List<Integer> list = this.createList(); //编译错误
//		List<? extends Integer> list = this.createList(); //编译错误
		List<? extends Number> list = this.createList(); 
		
		//List<? extends Number>是List<? extends Object>的子类型 
		List<? extends Object> list2 = this.createList(); 
		
	}
}
