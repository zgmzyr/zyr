/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._5_genericAndArray._2;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Varargs.java $Date: 2013-4-5 下午7:11:58 -0400 2013
 * @since 1.0
 * 
 */
public class Varargs {

	public void varargsMethod(List<String>... stringListArray) {
		Object[] array = stringListArray;
//		List<String>[] array = stringListArray;
		List<Integer> integerList = (List<Integer>) array[0];
		integerList.add(1);
	}
	
	public void useVarargsMethod() {
		List<String> stringList = new ArrayList<>();
		stringList.add("zyr");
		
		this.varargsMethod(stringList);
		
		System.out.println(stringList.get(1));
	}
	
	public static void main(String[] args) {
		Varargs varargs = new Varargs();
		varargs.useVarargsMethod();
	}
}
