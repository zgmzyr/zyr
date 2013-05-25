/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._2;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Sample.java $Date: 2013-3-18 下午10:07:35 -0400 2013
 * @since 1.0
 * 
 */
public class Sample {
	private Sample obj;

	/*public void setSample(Sample obj) {
		this.obj = obj;
	}*/
	
	public void setSample(Object obj) {
		this.obj = (Sample) obj;
		
		System.out.println(obj);
	}
}
