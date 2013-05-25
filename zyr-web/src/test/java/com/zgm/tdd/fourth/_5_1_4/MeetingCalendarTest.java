package com.zgm.tdd.fourth._5_1_4;

import java.util.Date;
import org.junit.Test;


/**
 * 自定义断言模式
 * @author zgm
 *
 */
public class MeetingCalendarTest {

	@Test
	public void timeslotsAreOnWeekdaysTest() throws Exception {
		MeetingCalendar calendar = new MeetingCalendar();
		
		Date time = calendar.nextAvailableStartingTime();
		
		this.assertIsDuringOfficeHoursOnWeekday(time);
	}

	private void assertIsDuringOfficeHoursOnWeekday(Date time) {
		// TODO Auto-generated method stub
		
	}
	
	
}
