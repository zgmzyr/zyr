/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._safePublication;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: UnsafePublication.java $Date: Apr 16, 2013 2:37:30 PM -0400 2013
 * @since 1.0
 * 
 */
//不安全的发布
public class UnsafePublication2 {
//	public Holder holder;
	private static List<Holder> holderList = new ArrayList<Holder>() ;//安全发布,但...
	
	public static void main(String[] args) {
		Holder holder = new Holder(11);
		holderList.add(holder);
		
		Thread thread = new Thread() {

			@Override
			public void run() {
				Holder holder = holderList.get(0);//TODO 由于重排序，应该也有可能报数组越界
				System.out.println(holder); 
				holder.assertSanity(); //TODO 由于没有同步，可见性得不到保证，可能会抛AssertionError
			}
		};
		
		thread.start();
//		holderList.add(holder);
	}
}
