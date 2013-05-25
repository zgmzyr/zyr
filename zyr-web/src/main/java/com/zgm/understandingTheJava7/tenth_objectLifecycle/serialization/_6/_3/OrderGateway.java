/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._3;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: OrderGateway.java $Date: 2013-3-17 下午9:20:32 -0400 2013
 * @since 1.0
 * 
 */
public class OrderGateway {
	public static Order getOrder(String id) {
		User user = new User("alex", "alex@example.org");
		return new Order(id, user);
	}
}
