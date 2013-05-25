/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._116;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: IfNotNeedExceptionDonotUseException.java $Date: 2012-5-12
 *          下午10:56:39 -0400 2012
 * @since 1.0
 * 
 */
public class IfNotNeedExceptionDonotUseException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("a.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void m1() {
		File file = new File("a.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void m2() {
		File file = new File("a.txt");
		
		if (file.exists() && !file.isDirectory()) {
			try {
				FileInputStream fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			
		}
	}
}
