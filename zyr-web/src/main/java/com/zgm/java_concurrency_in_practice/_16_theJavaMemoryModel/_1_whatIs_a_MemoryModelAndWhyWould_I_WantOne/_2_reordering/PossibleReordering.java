/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._1_whatIs_a_MemoryModelAndWhyWould_I_WantOne._2_reordering;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PossibleReordering.java $Date: Jun 18, 2013 10:07:52 AM -0400 2013
 * @since 1.0
 * 
 */
public class PossibleReordering {
	static int x = 0, y = 0;
	static int a = 0, b = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(new Runnable() {
			public void run() {
				a = 1;
				x = b;
			}
		});
		
		Thread other = new Thread(new Runnable() {
			public void run() {
				b = 1;
				y = a;
			}
		});
		
		one.start();
		other.start();
		one.join();
		other.join();
		System.out.println("( " + x + "," + y + ")");
	}
}
