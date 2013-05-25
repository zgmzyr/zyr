/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._2._2;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: NewUser.java $Date: 2013-3-17 下午8:42:48 -0400 2013
 * @since 1.0
 * 
 */
public class NewUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private transient Date birthDate;

	public NewUser(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return dateToAge(birthDate);
	}

	private Date ageToDate(int age) {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int newYear = currentYear - age;
		calendar.set(Calendar.YEAR, newYear);
		return calendar.getTime();
	}

	private int dateToAge(Date date) {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		calendar.setTime(birthDate);
		int birthYear = calendar.get(Calendar.YEAR);
		int age = currentYear - birthYear;
		return age;
	}

	private void writeObject(ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		int age = dateToAge(birthDate);
		output.writeInt(age);
		System.out.println(age);
	}

	private void readObject(ObjectInputStream input) throws IOException,
			ClassNotFoundException {
		input.defaultReadObject();
		int age = input.readInt();
		this.birthDate = ageToDate(age);

		input.registerValidation(new UserValidator(this), 0);
	}

	private static class UserValidator implements ObjectInputValidation {
		private NewUser user;

		public UserValidator(NewUser user) {
			this.user = user;
		}

		public void validateObject() throws InvalidObjectException {
			if (user.getAge() < 0) {
				throw new InvalidObjectException("非法的年龄数值。");
			}
		}
	}
}
