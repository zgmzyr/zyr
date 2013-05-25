/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.webservices.server;

import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;


/**
 * 
 * @author 周光明 Exp
 * @version $FileName: DeployeWebServices.java $Date: 2012-7-7 下午7:47:49 -0400 2012
 * @since 1.0
 * 
 */
public class DeployeWebServices {

	public static void main(String[] args) {
		WebServicesTest test = new WebServicesTest();
		Endpoint endpoint = Endpoint.publish("http://localhost2:8080/hello", test);
//		Binding binding = endpoint.getBinding();
//		
//		List<Handler> handlerChain = new LinkedList<Handler>();
////		handlerChain.add(new TraceHandler());
//		binding.setHandlerChain(handlerChain);
	}
}
