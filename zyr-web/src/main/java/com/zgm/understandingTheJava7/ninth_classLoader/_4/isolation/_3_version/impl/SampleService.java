/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._3_version.impl;

import com.zgm.understandingTheJava7.ninth_classLoader._4.isolation._3_version.Versionized;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SampleService.java $Date: 2013-3-27 下午9:22:15 -0400 2013
 * @since 1.0
 * 
 */
public class SampleService implements Versionized {

	@Override
	public String getVersion() {
		return "2.0";
	}

}
