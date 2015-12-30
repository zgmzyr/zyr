package com.zgm.tool.date;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期格式化解析工具类   
 * 
 * @author zhouguangming 
 * 创建时间: 2014年7月3日 下午7:11:52
 */
public class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {

	private static final Logger log = LoggerFactory.getLogger(DateFormatUtils.class);

	/**
	 * pattern
	 */
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
	public static final String yyyy_MM_dd_HH = "yyyy-MM-dd HH";
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	public static final String MM_dd_HH_mm = "MM-dd HH:mm";
	public static final String MM_dd = "MM-dd";
	public static final String HH_mm = "HH:mm";
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String yyyyMMdd = "yyyyMMdd";
	public static final String chinese_yyyy_MM_dd_HH_mm = "yyyy-MM-dd日 HH时mm分";
	public static final String chinese_yyyy_MM_dd = "yyyy年MM月dd日";
	public static final String chinese_MM_dd_HH_mm = "MM-dd日 HH时mm分";
	public static final String chinese_M_d = "M月d日";

	/**
	 * 获取指定日期的中文星期表示 <p>
	 * 如传入date参数表示的日期是monday，则返回中文形式的“星期一”,余下依此类推
	 * 
	 * @param date
	 */
	public static String getChieseWeekDay(Date date) {
		if (date == null) {
			return null;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int field = calendar.get(Calendar.DAY_OF_WEEK);
		switch (field) {
		case Calendar.SUNDAY:
			return "周日";
		case Calendar.MONDAY:
			return "周一";
		case Calendar.TUESDAY:
			return "周二";
		case Calendar.WEDNESDAY:
			return "周三";
		case Calendar.THURSDAY:
			return "周四";
		case Calendar.FRIDAY:
			return "周五";
		case Calendar.SATURDAY:
			return "周六";
		default:
			return null;
		}
	}

	/**
	 * 将指定字符串解析为Calendar类型的时间
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 */
	public static Calendar parseToCalendar(final String dateString, final String pattern) {
		return parseToCalendar(dateString, pattern, null);
	}

	/**
	 * 将指定字符串解析为Calendar类型的时间
	 * 
	 * @param dateString
	 * @param pattern
	 * @param timeZone
	 * @return
	 */
	public static Calendar parseToCalendar(final String dateString, final String pattern, final TimeZone timeZone) {
		return parseToCalendar(dateString, pattern, timeZone, null);
	}

	/**
	 * 将指定字符串解析为Calendar类型的时间
	 * 
	 * @param dateString
	 * @param pattern
	 * @param timeZone
	 * @param locale
	 * @return
	 */
	public static Calendar parseToCalendar(final String dateString, final String pattern, final TimeZone timeZone, final Locale locale) {
		Date date = parseToDate(dateString, pattern, timeZone, locale);
		if (date == null) {
			return null;
		}

		return DateUtils.toCalendar(date);
	}

	/**
	 * 将指定字符串解析为Date类型的时间
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 */
	public static Date parseToDate(final String dateString, final String pattern) {
		return parseToDate(dateString, pattern, null);
	}

	/**
	 * 将指定字符串解析为Date类型的时间
	 * 
	 * @param dateString
	 * @param pattern
	 * @param timeZonen
	 * @return
	 */
	public static Date parseToDate(final String dateString, final String pattern, final TimeZone timeZonen) {
		return parseToDate(dateString, pattern, timeZonen, null);
	}

	/**
	 * 将指定字符串解析为Date类型的时间
	 * 
	 * @param dateString
	 * @param pattern
	 * @param timeZone
	 * @param locale
	 * @return
	 */
	public static Date parseToDate(final String dateString, final String pattern, final TimeZone timeZone, final Locale locale) {
		try {
			FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
			return df.parse(dateString);
		} catch (ParseException e) {
			log.error("{msg:'parsed error:dateString={},pattern={},timeZone={},locale={}'}",
					dateString, pattern, timeZone, locale, e.getMessage());

		}

		return null;
	}
}

