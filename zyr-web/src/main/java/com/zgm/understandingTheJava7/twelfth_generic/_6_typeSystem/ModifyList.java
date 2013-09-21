/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._6_typeSystem;

import java.util.ArrayList;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ModifyList.java $Date: 2013-4-5 下午7:47:40 -0400 2013
 * @since 1.0
 * 
 */
public class ModifyList {

	public void modify(ArrayList<Number> numberList) {
		numberList.add(1.1f);
	}
	
	public void changeList() {
		ArrayList<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		
//		this.modify(integerList);// 编译错误
		
	}
	
}
