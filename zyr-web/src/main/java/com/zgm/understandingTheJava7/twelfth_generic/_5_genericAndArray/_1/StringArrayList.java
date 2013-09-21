/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._5_genericAndArray._1;

import java.util.ArrayList;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: StringArrayList.java $Date: 2013-4-5 上午11:09:08 -0400 2013
 * @since 1.0
 * 
 */
public class StringArrayList extends ArrayList<String> {
	
	public void createArray() {
		ArrayList<String>[] array = new StringArrayList[10];
	}
}
