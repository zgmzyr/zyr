/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.twelfth_generic._2_typeErasure._2_bridge;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Sequence.java $Date: 2013-4-2 下午9:17:16 -0400 2013
 * @since 1.0
 * 
 */
public class Sequence implements Comparable<Sequence> {

	private int number;
	
	public Sequence() {}
	
	public Sequence(int number) {
		this.number = number;
	}
	
	@Override
	public int compareTo(Sequence sequence) {
		return Integer.compare(this.number, sequence.number);
	}

}
