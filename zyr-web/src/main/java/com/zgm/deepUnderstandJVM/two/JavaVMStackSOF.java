/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.deepUnderstandJVM.two;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: JavaVMStackSOF.java $Date: 2012-12-24 下午10:14:43 -0400 2012
 * @since 1.0
 * 
 */
public class JavaVMStackSOF {

	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
		try {
			javaVMStackSOF.stackLeak();
		} catch (Throwable e) {
			System.out.println("栈深度为：" + javaVMStackSOF.stackLength);
			
			throw e;
		}
	}
}
