/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._1_concept;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ObjectHolder.java $Date: 2013-4-2 下午9:06:11 -0400 2013
 * @since 1.0
 * 
 */
public class ObjectHolder<T> {

	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}
