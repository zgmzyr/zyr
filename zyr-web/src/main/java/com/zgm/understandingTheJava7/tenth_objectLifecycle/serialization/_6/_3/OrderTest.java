/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._3;

import java.io.IOException;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: OrderTest.java $Date: 2013-3-17 下午9:34:12 -0400 2013
 * @since 1.0
 * 
 */
public class OrderTest {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		User user = new User("Bob", "bob@example.org");
		Order order = new Order("1", user);
		String path = "order.bin";
		SerializationUtils.write(order, path);
		order = (Order) SerializationUtils.read(path);
		System.out.println(order.getId());
	}

}
