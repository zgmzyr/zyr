package com.zgm.test;

public class StaticClassTest {

//	private static volatile String staticField;
	private static String staticField;
	
	public void set() {
		/*synchronized (StaticClassTest.class) {
			staticField = "zyr";
		}*/

		staticField = "zyr";
	}
}
