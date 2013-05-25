/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._6;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._3.SerializationUtils;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ExternalizableUser.java $Date: 2013-3-18 下午8:23:34 -0400
 *          2013
 * @since 1.0
 * 
 */
public class ExternalizableUser implements Externalizable {

	private String name;
	private String email;

	/**
	 * 必须要提供一个无参构造方法，在反序列化时，先调用此无参构造方法构建一个对象，然后再在此基础上调用readExternal方法
	 */
	public ExternalizableUser() {
	}

	public ExternalizableUser(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(getName());
		out.writeUTF(getEmail());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = in.readUTF();
		email = in.readUTF();
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		ExternalizableUser user = new ExternalizableUser("Alex",
				"alex@example.org");
		String filePath = "e_user.bin";
		SerializationUtils.write(user, filePath);
		user = (ExternalizableUser) SerializationUtils.read(filePath);
		System.out.println(user.getEmail());
	}

}
