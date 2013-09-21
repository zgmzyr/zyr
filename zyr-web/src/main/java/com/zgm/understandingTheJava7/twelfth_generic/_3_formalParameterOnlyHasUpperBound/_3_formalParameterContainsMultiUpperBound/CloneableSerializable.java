/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._3_formalParameterOnlyHasUpperBound._3_formalParameterContainsMultiUpperBound;

import java.io.Serializable;
import java.util.Collections;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CloneableSerializable.java $Date: 2013-4-4 上午11:46:20 -0400 2013
 * @since 1.0
 * 
 */
public class CloneableSerializable<T extends Comparable & Serializable> {

	public static void main(String[] args) {
		CloneableSerializable<Integer> coCloneableSerializable = new CloneableSerializable<>();
	}
}
