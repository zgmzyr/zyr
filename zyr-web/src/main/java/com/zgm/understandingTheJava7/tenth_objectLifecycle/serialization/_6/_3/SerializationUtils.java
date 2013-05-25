/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SerializationUtils.java $Date: 2013-3-17 下午9:34:58 -0400
 *          2013
 * @since 1.0
 * 
 */
public class SerializationUtils {
	public static void write(Object obj, String filePath) throws IOException {
		Path path = Paths.get(filePath);
		try (ObjectOutputStream output = new ObjectOutputStream(
				Files.newOutputStream(path))) {
			output.writeObject(obj);
		}
	}

	public static Object read(String filePath) throws IOException,
			ClassNotFoundException {
		Path path = Paths.get(filePath);
		try (ObjectInputStream input = new ObjectInputStream(
				Files.newInputStream(path))) {
			return input.readObject();
		}
	}
}
