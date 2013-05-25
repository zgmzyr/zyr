/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.tenth_objectLifecycle.serialization._6._1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ReadUser.java $Date: 2013-3-13 下午9:40:14 -0400 2013
 * @since 1.0
 * 
 */
public class ReadUser {

	public User readUser() throws IOException, ClassNotFoundException {
        Path path = Paths.get("user.bin");
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(path))) {
            User user = (User) input.readObject();
            return user;
        }
    }
   
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ReadUser readUser = new ReadUser();
        User user = readUser.readUser();
        System.out.println(user.getEmail());
    }
}
