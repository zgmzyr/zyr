package com.zgm.java.util.Calendar;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import com.zgm.tool.date.DateFormatUtils;

public class CalendarTest {

	
	@Test
	public void test() {
		System.out.println(getOnTheＨour(15).toInstant().toString());
		System.out.println(getOnTheＨour(20).toInstant().toString());

		System.out.println(getOnTheＨour(15).toString());
		System.out.println(getOnTheＨour(20).toString());
	}
	
	
	@Test
	public void test2() {
		Calendar big = Calendar.getInstance();
		Calendar small = Calendar.getInstance();
		small.add(Calendar.DAY_OF_MONTH, -2);
		small.add(Calendar.HOUR_OF_DAY, 1);
		
		
		assertTrue(getDayIntervals(big, small) == 3);
	}
	
	@Test
	public void test3() {
		String format = format("9163970");
		
		System.out.println(format);

		String format2 = format("19163970");
		System.out.println(format2);

		String format3 = format("10163970");
		System.out.println(format3);

		String format4 = format("08163970");
		System.out.println(format4);
		assertTrue(format.equals("09:16"));
	}


	private String format(String str) {
		String format = DateFormatUtils.format(DateFormatUtils.parseToCalendar(str, "HHmmssSSS"), "HH:mm");
		return format;
	}
	
	public int getDayIntervals(Calendar big, Calendar small) {
//	public int getDayIntervals(Calendar small, Calendar big) {
		if (big.get(Calendar.DAY_OF_YEAR) == small.get(Calendar.DAY_OF_YEAR)) {
			return 1;
		} else {
			long oneDay = 24 * 60 * 60 * 1000;
			Calendar bigCopy = (Calendar) big.clone();
			bigCopy.set(small.get(Calendar.YEAR), small.get(Calendar.MONTH), small.get(Calendar.DAY_OF_MONTH));
			long differTimeTemp = bigCopy.getTimeInMillis() - small.getTimeInMillis();
			long realDifferTime = big.getTimeInMillis() - small.getTimeInMillis();
			if (differTimeTemp > 0) {
				return Long.valueOf(realDifferTime / oneDay + 1).intValue();
			} else {
				return Long.valueOf(realDifferTime / oneDay + 2).intValue();
			}
		}
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
