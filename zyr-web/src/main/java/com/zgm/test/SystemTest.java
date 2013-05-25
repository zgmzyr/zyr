/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.test;

import java.io.IOException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SystemTest.java $Date: 2012-12-16 上午11:36:37 -0400 2012
 * @since 1.0
 * 
 */
public class SystemTest {
	public static void main(String[] args)  {
		try {
			Runtime.getRuntime().exec("cmd /c dir");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
