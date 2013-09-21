/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._8_typeInference._2_typeInference._2_baseOnEvaluate;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TypeInference.java $Date: 2013-4-14 上午10:23:16 -0400 2013
 * @since 1.0
 * 
 */
public class TypeInference {

	public <T> T method(T obj) {
		return obj;
	}
	
	public <T> List<T> createList() {
		return new ArrayList<T>();
	}
}
