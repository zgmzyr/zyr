/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.webservices.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: WebServicesTest.java $Date: 2012-7-7 下午7:38:31 -0400 2012
 * @since 1.0
 * 
 */
@WebService
public class WebServicesTest {

	@WebMethod
	//TODO
	public String sayHello(String username) {
		
		return "Hello, " + username;
	}
	
	
}
