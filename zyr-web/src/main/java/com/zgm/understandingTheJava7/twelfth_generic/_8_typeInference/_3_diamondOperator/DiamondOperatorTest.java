/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._8_typeInference._3_diamondOperator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: DiamondOperatorTest.java $Date: 2013-4-14 下午3:33:54 -0400 2013
 * @since 1.0
 * 
 */
public class DiamondOperatorTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Map<List<? extends Number>, Map<String, Long>> map = new HashMap<List<? extends Number>, Map<String, Long>>();
		
		List<String> list2 = new ArrayList<>();
		Map<List<? extends Number>, Map<String, Long>> map2 = new HashMap<>();
	}
}
