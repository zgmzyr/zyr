package com.zgm.java.text.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest extends Thread {
	@Override
	public void run() {
		while (true) {
			try {
				this.join(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				System.out.println(DateUtil.parse("2011-10-11 06:02:20"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			new SimpleDateFormatTest().start();
	}
}

class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static Date parse(String str) throws ParseException {
		return sdf.parse(str);
	}
}
