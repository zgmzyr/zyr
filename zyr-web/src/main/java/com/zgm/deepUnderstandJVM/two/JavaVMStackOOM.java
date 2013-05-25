/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.deepUnderstandJVM.two;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: JavaVMStackOOM.java $Date: 2012-12-24 下午10:24:54 -0400 2012
 * @since 1.0
 * 
 */
public class JavaVMStackOOM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
		javaVMStackOOM.stackLeakByThread();
	}

	private void dontStop() {
		while (true) {
			
		}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					dontStop();
				}
			});
			
			thread.start();
		}
	}
}
