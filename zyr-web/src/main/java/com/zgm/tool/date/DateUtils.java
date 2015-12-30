package com.zgm.tool.date;


import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类:专用于时间转化计算等 <p>
 * 注：日期的格式化和解析请 查看 {@link DateFormatUtils}
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/**
	 * 获取指定时间之间的毫秒间隔数
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getMilliSecondIntervals(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, 1, false); 
	}

	/**
	 * 获取指定时间之间的毫秒间隔数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getMilliSecondIntervals(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, 1, false);
	}

	/**
	 * 获取指定时间之间的秒间隔数
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getSecondIntervals(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_SECOND, false);
	}

	/**
	 * 获取指定时间之间的秒间隔数
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getSecondIntervals(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_SECOND, false);
	}

	/**
	 * 获取指定时间之间的分钟间隔数,不忽略秒. <p>
	 * e.g.: beginCalendar = 2014-6-20 12:20:00, endCalendar = 2014-6-20 12:29:05,则返回值为10
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getMinuteIntervals(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_MINUTE, false);
	}

	/**
	 * 获取指定时间之间的分钟间隔数,不忽略秒. <p>
	 * e.g.: beginDate = 2014-6-20 12:20:00, endDate = 2014-6-20 12:29:05,则返回值为10
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getMinuteIntervals(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_MINUTE, false);
	}

	/**
	 * 获取指定时间之间的分钟间隔数,忽略秒. <p>
	 * e.g.: beginCalendar = 2014-6-20 12:20:00, endCalendar = 2014-6-20 12:29:05,则返回值为9
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getMinuteIntervalsIgnoreSecond(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_MINUTE, true);
	}

	/**
	 * 获取指定时间之间的分钟间隔数,忽略秒. <p>
	 * e.g.: beginDate = 2014-6-20 12:20:00, endDate = 2014-6-20 12:29:05,则返回值为9
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getMinuteIntervalsIgnoreSecond(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_MINUTE, true);
	}

	/**
	 * 获取指定时间之间的小时间隔数,不忽略分. <p>
	 * e.g.: beginCalendar = 2014-6-20 06:20:00, endCalendar = 2014-6-20 12:29:05,则返回值为7
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getHourIntervals(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_HOUR, false);
	}

	/**
	 * 获取指定时间之间的小时间隔数,不忽略分. <p>
	 * e.g.: beginDate = 2014-6-20 06:20:00, endDate = 2014-6-20 12:29:05,则返回值为7
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getHourIntervals(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_HOUR, false);
	}

	/**
	 * 获取指定时间之间的小时间隔数,忽略分. <p>
	 * e.g.: beginCalendar = 2014-6-20 06:20:00, endCalendar = 2014-6-20 12:29:05,则返回值为6
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getHourIntervalsIgnoreMinute(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_HOUR, true);
	}

	/**
	 * 获取指定时间之间的小时间隔数,忽略分. <p>
	 * e.g.: beginDate = 2014-6-20 06:20:00, endDate = 2014-6-20 12:29:05,则返回值为6
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getHourIntervalsIgnoreMinute(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_HOUR, true);
	}

	/**
	 * 获取指定时间之间的小时间隔数,不忽略时. <p>
	 * e.g.: beginCalendar = 2014-6-10 06:20:00, endCalendar = 2014-6-19 12:29:05,则返回值为10
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getDayIntervals(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_DAY, false);
	}

	/**
	 * 获取指定时间之间的小时间隔数,不忽略时. <p>
	 * e.g.: beginDate = 2014-6-10 06:20:00, endDate = 2014-6-19 12:29:05,则返回值为10
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDayIntervals(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_DAY, false);
	}

	/**
	 * 获取指定时间之间的小时间隔数,忽略时. <p>
	 * e.g.: beginCalendar = 2014-6-10 06:20:00, endCalendar = 2014-6-19 12:29:05,则返回值为9
	 * 
	 * @param beginCalendar
	 * @param endCalendar
	 * @return
	 */
	public static int getDayIntervalsIgnoreHour(final Calendar beginCalendar, final Calendar endCalendar) {
		return doGetIntervals(beginCalendar, endCalendar, MILLIS_PER_DAY, true);
	}

	/**
	 * 获取指定时间之间的小时间隔数,忽略时. <p>
	 * e.g.: beginDate = 2014-6-10 06:20:00, endDate = 2014-6-19 12:29:05,则返回值为9
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDayIntervalsIgnoreHour(final Date beginDate, final Date endDate) {
		return doGetIntervals(beginDate, endDate, MILLIS_PER_DAY, true);
	}

	private static int doGetIntervals(final Calendar beginCalendar, final Calendar endCalendar, long millisPerSome, boolean ignore) {
		if (beginCalendar == null || endCalendar == null) {
			throw new IllegalStateException("非法参数:开始时间和结束时间应该不为空且结束时间应该不小于开始时间");
		}

		return doGetIntervals(beginCalendar.getTime(), endCalendar.getTime(), millisPerSome, ignore);
	}

	private static int doGetIntervals(final Date beginDate, final Date endDate, long millisPerSome, boolean ignore) {
		if (beginDate == null || endDate == null || (endDate.getTime() < beginDate.getTime())) {
			throw new IllegalStateException("非法参数:开始时间和结束时间应该不为空且结束时间应该不小于开始时间");
		}

		long intervals = 0;
		if (ignore) {
			int field = Calendar.MILLISECOND; 
			if (millisPerSome == MILLIS_PER_SECOND) {
				field = Calendar.SECOND;
			} else if (millisPerSome == MILLIS_PER_MINUTE) {
				field = Calendar.MINUTE;
			} else if (millisPerSome == MILLIS_PER_HOUR) {
				field = Calendar.HOUR;
			} else if (millisPerSome == MILLIS_PER_DAY) {
				field = Calendar.DAY_OF_MONTH;
			}

			Date beginTime = truncate(beginDate, field);
			Date endTime = truncate(endDate, field);
			final long differTime = endTime.getTime() - beginTime.getTime();
			intervals = differTime / millisPerSome;
		} else {
			final long differTime = endDate.getTime() - beginDate.getTime();
			intervals = differTime % millisPerSome > 0 ? differTime / millisPerSome + 1 : differTime / millisPerSome;
		}

		return Long.valueOf(intervals).intValue();
	}

	/**
	 * 检查今天是否为指定日期的后一天 <p>
	 * 例: 假如今天是2014-07-17, 若参数 yesterday 表示的时间为2014-07-16,则返回ture
	 * 
	 * @param yesterday
	 * @return
	 */
	public static boolean todayIsNextDayOf(Calendar yesterday) {
		if (yesterday == null) {
			return false;
		}

		if (getDayIntervalsIgnoreHour(yesterday, now()) == 1) {
			return true;
		}

		return false;
	}

	/**
	 * 检查今天是否为指定日期的后几天(包括后一天) <p>
	 * 例: 假如今天是2014-07-17, 若参数 theOtherDay 表示的时间为2014-07-14,则返回ture
	 * 
	 * @param theOtherDay
	 * @return
	 */
	public static boolean todayAfter(Calendar theOtherDay) {
		if (theOtherDay == null) {
			return false;
		}

		try {
			if (getDayIntervalsIgnoreHour(theOtherDay, now()) >= 1) {
				return true;
			}
		} catch (IllegalStateException e) {
			return false;
		}

		return false;
	}

	/**
	 * 获取当前时间的年域(field)的值
	 * 
	 * @return
	 */
	public static int getCurrentYear() {
		return now().get(Calendar.YEAR);
	}

	/**
	 * 获取当前时间的月域(field)的值
	 * 
	 * @return
	 */
	public static int getCurrentMonth() {
		return now().get(Calendar.MONTH);
	}

	/**
	 * 获取当前日期属于该时间所在年第几周 <p>
	 * 例: 假如当前日期为2014-07-18 , 则返回28,即当前日期属于当年的第28周
	 * 
	 * return
	 */
	public static int getWeekNumberOfYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setMinimalDaysInFirstWeek(7);
		
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取指定日期所在周的星期一
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getMonday(final Calendar day) {
		return getDayOfWeek(day, Calendar.MONDAY);
	}

	/**
	 * 获取指定日期所在周的星期二
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getTuesday(final Calendar day) {
		return getDayOfWeek(day, Calendar.TUESDAY);
	}

	/**
	 * 获取指定日期所在周的星期三
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getWednesday(final Calendar day) {
		return getDayOfWeek(day, Calendar.WEDNESDAY);
	}

	/**
	 * 获取指定日期所在周的星期四
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getThursday(final Calendar day) {
		return getDayOfWeek(day, Calendar.THURSDAY);
	}

	/**
	 * 获取指定日期所在周的星期五
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getFriday(final Calendar day) {
		return getDayOfWeek(day, Calendar.FRIDAY);
	}

	/**
	 * 获取指定日期所在周的星期六
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getSaturday(final Calendar day) {
		return getDayOfWeek(day, Calendar.SATURDAY);
	}

	/**
	 * 获取指定日期所在周的星期天
	 * <p>
	 * 注:默认情况下,每周的开始是从星期天开始的,即星期天是每周的第一天,但在国内,是从星期一开始,我们的业务也是星期一开始,星期天结束，
	 *   所以此方法返回的星期天是一周的最后一天
	 * 
	 * @param day
	 *            指定的日期.注:不能为空
	 * @return
	 */
	public static Calendar getSunday(final Calendar day) {
		return getDayOfWeek(day, Calendar.SUNDAY);
	}
	
	/**
	 * 获取指定日期所在周的某一天 <p> 
	 * 注：只改变天域（field），其它域都不变，如: 参数day表示的时间为2014/07/14 18:22:30,此时间是星期一，假如参数dayOfWeek=4，即要获取
	 *  该时间所在周的星期三，则调用此方法后，返回的时间是2014/07/16 18:22:30
	 * 
	 * @param day
	 * @param dayOfWeek
	 *            1 <= dayOfWeek <= 7 注意: dayOfWeek == 1时表示星期天,其余依次类推
	 * @return
	 */
	private static Calendar getDayOfWeek(final Calendar day, int dayOfWeek) {
		if (day == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}

		if (dayOfWeek == Calendar.SUNDAY) {
			dayOfWeek += 7;
		}
		int intervalDays = dayOfWeek - day.get(Calendar.DAY_OF_WEEK);
		Calendar result = (Calendar) day.clone();
		result.setFirstDayOfWeek(Calendar.MONDAY); //设置一周的开始是星期一
		result.add(Calendar.DAY_OF_YEAR, intervalDays);

		return result;
	}
	
	/**
	 * 获取今天的最小时间 <p>
	 * 例：假如今天当前时间是2014/07/14 13:22:33， 则返回2014/07/14 00:00:00
	 */
	public static Calendar getStartCalendarOfToday() {
		return getStartCalendar(Calendar.getInstance());
	}
	
	/**
	 * 获取今天的最小时间 <p>
	 * 例：假如今天当前时间是2014/07/14 13:22:33， 则返回2014/07/14 00:00:00
	 */
	public static Date getStartDateOfToday() {
		return getStartDate(Calendar.getInstance());
	}

	/**
	 * 获取今天的最大时间 <p>
	 * 例：假如今天当前时间是2014/07/14 13:22:33， 则返回2014/07/14 23:59:59
	 */
	public static Calendar getEndCalendarOfToday() {
		return getEndCalendar(Calendar.getInstance());
	}
	
	/**
	 * 获取今天的最大时间 <p>
	 * 例：假如今天当前时间是2014/07/14 13:22:33， 则返回2014/07/14 23:59:59
	 * 
	 * @return
	 */
	public static Date getEndDateOfToday() {
		return getEndDate(Calendar.getInstance());
	}
	
	/**
	 * 获取指定日期的最小时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 00:00:00
	 * 
	 * @param calendar 指定日期
	 * @return
	 */
	public static Date getStartDate(final Calendar calendar) {
		return getStartCalendar(calendar).getTime();
	}
	
	/**
	 * 获取指定日期的最小时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 00:00:00
	 * 
	 * @param calendar 指定日期
	 * @return
	 */
	public static Calendar getStartCalendar(final Calendar calendar) {
		if (calendar == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}

		return getStartCalendar(calendar.getTime());
	}
	
	/**
	 * 获取指定日期的最小时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 00:00:00
	 * 
	 * @param date 指定日期
	 * @return
	 */
	public static Date getStartDate(final Date date) {
		return getStartCalendar(date).getTime();
	}
	
	/**
	 * 获取指定日期的最小时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 00:00:00
	 * 
	 * @param date 指定日期
	 * @return
	 */
	public static Calendar getStartCalendar(final Date date) {
		if (date == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}

		Calendar result = Calendar.getInstance();
		result.setTime(date);
		result.set(Calendar.HOUR_OF_DAY, 0);
		result.set(Calendar.MINUTE, 0);
		result.set(Calendar.SECOND, 0);
		result.set(Calendar.MILLISECOND, 0);
		
		return result;
	}
	
	/**
	 * 获取指定日期的最大时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 23:59:59
	 * 
	 * @param calendar 指定日期
	 * @return
	 */
	public static Date getEndDate(final Calendar calendar) {
		return getEndCalendar(calendar).getTime();
	}
	
	/**
	 * 获取指定日期的最大时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 23:59:59
	 * 
	 * @param calendar 指定日期
	 * @return
	 */
	public static Calendar getEndCalendar(final Calendar calendar) {
		if (calendar == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}

		return getEndCalendar(calendar.getTime());
	}
	
	/**
	 * 获取指定日期的最大时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 23:59:59
	 * 
	 * @param date 指定日期
	 * @return
	 */
	public static Date getEndDate(final Date date) {
		return getEndCalendar(date).getTime();
	}
	
	/**
	 * 获取指定日期的最大时间 <p>
	 * 例：假如指定日期时间是2014/07/14 13:22:33， 则返回2014/07/14 23:59:59
	 * 
	 * @param date 指定日期
	 * @return
	 */
	public static Calendar getEndCalendar(final Date date) {
		if (date == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}

		Calendar result = Calendar.getInstance();
		result.setTime(date);
		result.set(Calendar.HOUR_OF_DAY, 23);
		result.set(Calendar.MINUTE, 59);
		result.set(Calendar.SECOND, 59);
		result.set(Calendar.MILLISECOND, 999);
		
		return result;
	}

	/**
	 * 判断指定时间是否在其所在天的0点到9点之间  <p>
	 * <pre> 
	 * 不包含边界值，即开区间，例：
	 * (1) 指定时间为2014/07/14 13:22:33, 则返回false
	 * (2) 指定时间为2014/07/14 03:22:33, 则返回true
	 * (3) 指定时间为2014/07/14 00:00:00, 则返回false
	 * (4) 指定时间为2014/07/14 09:00:00, 则返回false
	 * </pre>
	 * 
	 * @param calendar 指定时间
	 * @return
	 */
	public static boolean validateDateBetween00And09(final Calendar calendar) {
		if (calendar == null) {
			return false;
		}

		return validateDateBetween00And09(calendar.getTime());
	}
	
	/**
	 * 判断指定时间是否在其所在天的0点到9点之间  <p>
	 * <pre>
	 * 不包含边界值，即开区间，例：
	 * (1) 指定时间为2014/07/14 13:22:33, 则返回false
	 * (2) 指定时间为2014/07/14 03:22:33, 则返回true
	 * (3) 指定时间为2014/07/14 00:00:00, 则返回false
	 * (4) 指定时间为2014/07/14 09:00:00, 则返回false
	 * </pre>
	 * 
	 * @param date 指定时间
	 * @return
	 */
	public static boolean validateDateBetween00And09(final Date date) {
		if (date == null) {
			return false;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Calendar calendar00 = (Calendar) calendar.clone();
		calendar00.set(Calendar.HOUR_OF_DAY, 0);
		calendar00.set(Calendar.MINUTE, 0);
		calendar00.set(Calendar.SECOND, 0);
		calendar00.set(Calendar.MILLISECOND, 0);

		Calendar calendar09 = (Calendar) calendar.clone();
		calendar09.set(Calendar.HOUR_OF_DAY, 9); 
		calendar09.set(Calendar.MINUTE, 0);
		calendar09.set(Calendar.SECOND, 0);
		calendar09.set(Calendar.MILLISECOND, 0);

		return calendar.after(calendar00) && calendar.before(calendar09);
	}

	/**
	 * 获取指定日期所在月的第一天的最小时间 <p> 
	 * 
	 * @param calendar 不能为空
	 * @return
	 */
	public static Calendar getFirstDayOfMonth(final Calendar calendar) {
		if (calendar == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}
		
		return getFirstDayOfMonth(calendar.getTime());
	}
	
	/**
	 * 获取指定日期所在月的第一天的最小时间 
	 */
	public static Calendar getFirstDayOfMonth(final Date date) {
		if (date == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}
		
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		result.set(Calendar.DAY_OF_MONTH, 1);
		result.set(Calendar.HOUR_OF_DAY, 0);
		result.set(Calendar.MINUTE, 0);
		result.set(Calendar.SECOND, 0); 
		result.set(Calendar.MILLISECOND, 0);

		return result;
	}

	/**
	 * 获取指定日期所在月的最后一天的最大时间
	 */
	public static Calendar getLastDayOfMonth(Calendar calendar) {
		if (calendar == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}
		
		return getLastDayOfMonth(calendar.getTime());
	}
	
	/**
	 * 获取指定日期所在月的最后一天的最大时间
	 */
	public static Calendar getLastDayOfMonth(Date date) {
		if (date == null) {
			throw new IllegalStateException("非法参数:日期不能为空");
		}
		
		Calendar result = Calendar.getInstance();
		result.setTime(date);
		// 本月的最后一天
		result.set(Calendar.DATE, 1);
		result.roll(Calendar.DATE, -1);
		result.set(Calendar.HOUR_OF_DAY, 23);
		result.set(Calendar.MINUTE, 59);
		result.set(Calendar.SECOND, 59);
		result.set(Calendar.MILLISECOND, 999);

		return result;
	}

	/**
	 * 获取前一天的时间
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar getLastDay(Calendar calendar) {
		return add(calendar, Calendar.DAY_OF_MONTH, -1);
	}

	/**
	 * 获取前一周的时间
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar getLastWeek(Calendar calendar) {
		return add(calendar, Calendar.WEEK_OF_MONTH, -1);
	}

	/**
	 * 获取前一月的时间
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar getLastMonth(Calendar calendar) {
		return add(calendar, Calendar.MONTH, -1);
	}

	/**
	 * 获取前三月的时间
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar getLastThreeMonth(Calendar calendar) {
		return add(calendar, Calendar.MONTH, -3);
	}
	
	/**
	 * 获取前一年的时间
	 * 
	 * @param calendar
	 * @return
	 */
	public static Calendar getLastYear(Calendar calendar) {
		return add(calendar, Calendar.YEAR, -1);
	}

	/**
	 * 增加时间
	 * 
	 * @param calendar
	 * @param calendarField
	 * @param amount
	 * @return
	 */
	public static Calendar add(final Calendar calendar, final int calendarField, final int amount) {
		if (calendar == null) {
			throw new IllegalArgumentException("The date must not be null");
		}

		final Calendar result = (Calendar) calendar.clone();
		result.add(calendarField, amount);

		return result;
	}
	
	/**
	 * 是否是今天 
	 */
	public static boolean isToday(Calendar calendar) {
		return isSameDay(calendar, now());
	}
	
	/**
	 * 是否是今天 
	 */
	public static boolean isToday(Date date) {
		return isSameDay(date, getCurrentDate());
	}

	/**
	 * 取得当前时间
	 */
	public static Calendar now() {
		return Calendar.getInstance();
	}

	public static Date getCurrentDate() {
		return now().getTime();
	}
}

