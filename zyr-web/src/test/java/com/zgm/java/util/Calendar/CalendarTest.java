package com.zgm.java.util.Calendar;

import java.util.Calendar;

import org.junit.Test;

public class CalendarTest {

	
	@Test
	public void test() {
		System.out.println(getOnTheＨour(15).toInstant().toString());
		System.out.println(getOnTheＨour(20).toInstant().toString());

		System.out.println(getOnTheＨour(15).toString());
		System.out.println(getOnTheＨour(20).toString());
	}
	
	private Calendar getOnTheＨour(int someHour) {
		Calendar onTheＨour = Calendar.getInstance();
		onTheＨour.set(Calendar.HOUR_OF_DAY, someHour);
		onTheＨour.set(Calendar.MINUTE, 0);
		onTheＨour.set(Calendar.SECOND, 0);
		onTheＨour.set(Calendar.MILLISECOND, 0);
		
		return onTheＨour;
	}
}
