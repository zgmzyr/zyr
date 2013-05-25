/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._127;

import java.util.Calendar;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Task.java $Date: 2012-5-15 下午8:52:41 -0400 2012
 * @since 1.0
 * 
 */
public class Task {
	public void doSomething() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("线程名称：" + Thread.currentThread().getName());
		sb.append("， 执行时间：" + Calendar.getInstance().get(13) + " s");
		System.out.println(sb);
	}
}
