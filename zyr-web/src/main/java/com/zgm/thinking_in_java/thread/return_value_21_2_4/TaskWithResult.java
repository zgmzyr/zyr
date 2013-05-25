/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.thinking_in_java.thread.return_value_21_2_4;

import java.util.concurrent.Callable;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TaskWithResult.java $Date: 2012-4-13 下午10:06:04 -0400 2012
 * @since 1.0
 * 
 */
public class TaskWithResult implements Callable<String> {
	private int id;
	@Override
	public String call() throws Exception {
		Thread.sleep(4110);
		return "id 是：　" + id;
	}
	public TaskWithResult(int id) {
		super();
		this.id = id;
	}

}
