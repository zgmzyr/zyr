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
 * @version $FileName: OrderTO.java $Date: 2013-3-17 下午9:15:48 -0400 2013
 * @since 1.0
 * 
 */
public class OrderTO implements Serializable {
	private String orderId;

	public OrderTO(Order order) {
		this.orderId = order.getId();
	}

	private Object readResolve() throws ObjectStreamException {
		return OrderGateway.getOrder(orderId);
	}
}
