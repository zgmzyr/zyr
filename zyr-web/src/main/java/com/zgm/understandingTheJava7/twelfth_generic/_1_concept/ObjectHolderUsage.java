/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._1_concept;

import com.zgm.understandingTheJava7.twelfth_generic._1.ObjectHolder;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ObjectHolderUsage.java $Date: 2013-4-2 下午9:08:36 -0400 2013
 * @since 1.0
 * 
 */
public class ObjectHolderUsage {
	public static void main(String[] args) {
//		ObjectHolder<String> holder = new ObjectHolder<String>();
		ObjectHolder<String> holder = new ObjectHolder<>();
		holder.setObj("hello, zry");
		String message = holder.getObj();
	}
}
