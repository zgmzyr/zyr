/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._2_thread_safety._2_1_raceConditions;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LazyInitRace.java $Date: Apr 11, 2013 9:22:10 AM -0400
 *          2013
 * @since 1.0
 * 
 */
// @NotThreadSafe
public class LazyInitRace {
	private ExpensiveObject instance = null;

	public ExpensiveObject getInstance() {
		if (instance == null)
			instance = new ExpensiveObject();
		return instance;
	}
}

class ExpensiveObject {
	private String name = "zyr";
	private int age = 18;

	ExpensiveObject() {
		this.name = "zgm";
		this.age = 29;
	}
	
	String getName() {
		return name;
	}
	
	int getAge() {
		return age;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setAge(int age) {
		this.age = age;
	}
}
