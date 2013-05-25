/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._3;

import java.io.ObjectStreamException;
import java.io.Serializable;


/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Order.java $Date: 2013-3-17 下午9:13:51 -0400 2013
 * @since 1.0
 * 
 */
public class Order implements Serializable {
	private User user;
	private String id;

	public Order(String id, User user) {
		this.id = id;
		this.user = user;
	}

	public String getId() {
		return this.id;
	}

	private Object writeReplace() throws ObjectStreamException {
		return new OrderTO(this);
	}
}
