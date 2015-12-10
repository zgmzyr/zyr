package com.zgm.java.lang.util.Calendar;

import java.util.Calendar;

import org.junit.Test;

public class CalendarTest {

	@Test
	public void test() {
		Calendar instance = Calendar.getInstance();
		System.out.println(instance.get(Calendar.MILLISECOND));
	}
}
