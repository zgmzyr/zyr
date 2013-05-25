/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._3;

import java.io.Serializable;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: User.java $Date: 2013-3-17 下午9:23:53 -0400 2013
 * @since 1.0
 * 
 */
public class User implements Serializable {
	// private static final ObjectStreamField[] serialPersistentFields = { new
	// ObjectStreamField("name", String.class) };

	private String name;
	private String email;
	private Address address;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
