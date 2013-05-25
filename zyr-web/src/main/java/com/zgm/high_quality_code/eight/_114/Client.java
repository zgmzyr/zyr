/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._114;

import java.io.IOException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Client.java $Date: 2012-5-10 下午9:57:51 -0400 2012
 * @since 1.0
 * 
 */
public class Client {
	public static void main(String[] args) {
		System.out.println("dosomething");
		
		try {
			Base base = new Base(); //此地方不能替换为子类，违背里氏替换原则
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
