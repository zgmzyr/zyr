/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._1_visiblity._4_countingSheep;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: CountingSheep.java $Date: Apr 15, 2013 1:51:09 PM -0400 2013
 * @since 1.0
 * 
 */
public class CountingSheep {
	private volatile boolean asleep;
	
	public void countSheep() {
		while (!asleep) {
			this.countSomeSheep();
		}
	}

	private void countSomeSheep() {
		System.out.println("数绵羊ing...");
	}

	boolean isAsleep() {
		return asleep;
	}

	void setAsleep(boolean asleep) {
		this.asleep = asleep;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		final CountingSheep cs = new CountingSheep();
		CountingSheep cs = new CountingSheep();
		final List<CountingSheep> list = new ArrayList<CountingSheep>();
		list.add(cs);
				
		Thread thread = new Thread() {

			@Override
			public void run() {
				CountingSheep cs = list.get(0);
				cs.setAsleep(true);
			}
		};
		
		thread.start();
		
		cs.countSheep();
	}

}
