/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._2_simple_servlet_container._1;

import java.io.IOException;

/**
 * 
 * @author 周光明
 * @version $FileName: StaticResourceProcessor.java $Date: 2013-7-21 下午2:49:30
 *          -0400 2013
 * @since 1.0
 * 
 */
public class StaticResourceProcessor {

	public void process(Request request, Response response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
