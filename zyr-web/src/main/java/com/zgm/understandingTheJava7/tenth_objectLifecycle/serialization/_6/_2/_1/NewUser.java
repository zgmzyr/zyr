/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._2._1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: NewUser.java $Date: 2013-3-17 下午8:24:45 -0400 2013
 * @since 1.0
 * 
 */
public class NewUser implements Serializable {
	private transient int age;

	public NewUser(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	private void writeObject(ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeInt(getAge());
	}

	private void readObject(ObjectInputStream input) throws IOException,
			ClassNotFoundException {
		input.defaultReadObject();
		int age = input.readInt();
		this.age = age;
	}
}
