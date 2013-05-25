/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._1_visiblity;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: NoVisibility.java $Date: Apr 12, 2013 2:05:58 PM -0400 2013
 * @since 1.0
 * 
 */
public class NoVisibility {
	private static boolean ready;
	private static int number;
	
	private static class ReaderThread extends Thread {

		@Override
		public void run() {
			while(!ready) {
				Thread.yield();
			}
			
//			System.out.println(Runtime.getRuntime().availableProcessors());
			System.out.println(number);
		}
	}
	
	public static void main(String[] args) {
		new ReaderThread().start();
		number = 40;
		ready = true;
	}
}
