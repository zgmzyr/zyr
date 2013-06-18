/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 30, 2013 1:53:44 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test222 {

	@Test
	public void test() throws IOException {
//		String parameters = "firstname=john&lastname=doe";
//		URL url = new URL("http://localhost:5050/servlet/zyr");
		URL url = new URL("http://192.168.0.14:5050/servlet/zyr");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//		URLConnection connection =  url.openConnection();
		connection.setAllowUserInteraction(true);
//		connection.setAllowUserInteraction(false);
		connection.setDoOutput(true);
//		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//		connection.setRequestProperty("Content-Type", "multipart/form-data");
		connection.setRequestMethod("POST");
		connection.connect();
//
		OutputStream out = connection.getOutputStream();
//		byte[] byteArray = new byte[] {1, 2, 3, 4, 5};
		
//		out.write(byteArray);
//		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//		out.write(parameters);
		out.flush();
		out.close();
		connection.disconnect();
//		connection.
	}
	
	
	public void test2() throws IOException {
//		String parameters = "firstname=john&lastname=doe";
		URL url = new URL("http://www.mywebsite.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestProperty("Content-Type", "multipart/form-data");
//		connection.setRequestMethod("POST");
		connection.setRequestMethod("GET");

		OutputStream out = connection.getOutputStream();
		byte[] byteArray = new byte[] {1, 2, 3, 4, 5};
		
		out.write(byteArray);
//		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//		out.write(parameters);
		out.flush();
		out.close();
		connection.disconnect();
	}
}
