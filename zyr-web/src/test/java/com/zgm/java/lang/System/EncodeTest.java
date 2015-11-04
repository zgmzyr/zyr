package com.zgm.java.lang.System;

import java.nio.charset.Charset;
import java.util.Properties;

import org.junit.Test;

public class EncodeTest {

	@Test
	public void test() {
		Properties initProp = new Properties(System.getProperties());
		System.out.println("file.encoding:" + initProp.getProperty("file.encoding"));
		System.out.println("user.language:" + initProp.getProperty("user.language"));
		
		System.out.println(Charset.defaultCharset());
	}
}
