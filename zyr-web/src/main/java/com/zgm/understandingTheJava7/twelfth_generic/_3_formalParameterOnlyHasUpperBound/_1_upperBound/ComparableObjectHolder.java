/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._3_formalParameterOnlyHasUpperBound._1_upperBound;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ComparableObjectHolder.java $Date: 2013-4-4 上午11:15:14 -0400 2013
 * @since 1.0
 * 
 */
public class ComparableObjectHolder<T extends Comparable<T>> {
	private T obj;
	
	public int compareeTo(T anothrerObj) {
		return obj.compareTo(anothrerObj);
	}
	
	public void test() {
		ComparableObjectHolder<Integer> holder = new ComparableObjectHolder<>();
	}
}
