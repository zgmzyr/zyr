/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._2._2;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: WriteUser.java $Date: 2013-3-13 下午9:39:55 -0400 2013
 * @since 1.0
 * 
 */
public class WriteUser {
	public void write(NewUser user) throws IOException {
		Path path = Paths.get("user.bin");
		try (ObjectOutputStream output = new ObjectOutputStream(
				Files.newOutputStream(path))) {
			output.writeObject(user);
		}
	}

	public static void main(String[] args) throws IOException {
		WriteUser writeUser = new WriteUser();
		Calendar calendar = Calendar.getInstance();
		calendar.set(1990, 01, 10);
		NewUser user = new NewUser(calendar.getTime());
		writeUser.write(user);
	}
}
