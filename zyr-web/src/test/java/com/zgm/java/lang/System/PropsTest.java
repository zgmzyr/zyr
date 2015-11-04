package com.zgm.java.lang.System;

import java.util.Properties;

import org.junit.Test;

public class PropsTest {

	
	
	@Test
	public void test() {
		System.out.println(System.getProperties());
		System.out.println("--------------------------");

		System.setProperties(new Properties());
		System.out.println(System.getProperties());

		System.setOut(System.err);
		System.out.println("--------------------------");
	}
}
