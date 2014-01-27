/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._3_formalParameterOnlyHasUpperBound._2_formalParameterIsUpperBound;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SampleClass.java $Date: 2013-4-4 上午11:38:00 -0400 2013
 * @since 1.0
 * 
 */
public class SampleClass<S extends T, T> {

	public static void main(String[] args) {
		SampleClass<Integer, Comparable<Integer>> sample = new SampleClass<>();
	}
}
