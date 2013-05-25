/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.eight._114;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Person.java $Date: 2012-5-10 下午9:34:56 -0400 2012
 * @since 1.0
 * 
 */
public class Person {

	public Person(int age) {
		if (age < 18) {
			throw new RuntimeException("年龄必须大于18岁！");
		}
	}
	
	public void seeMovie() {
		System.out.println("看限制级电影");
	}
	
	public static void main(String[] args) {
		Person person = new Person(17);
		person.seeMovie();
		
		//其它业务逻辑
	}
}
