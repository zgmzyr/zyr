/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.webservices.client;

import com.zgm.webservices.client.server.WebServicesTest;
import com.zgm.webservices.client.server.WebServicesTestService;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ClientTest.java $Date: 2012-7-8 下午12:39:25 -0400 2012
 * @since 1.0
 * 
 */
public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebServicesTestService server = new WebServicesTestService();
		WebServicesTest webServicesTest = server.getWebServicesTestPort();

		System.err.println(webServicesTest.sayHello("zyr"));
	}

}
