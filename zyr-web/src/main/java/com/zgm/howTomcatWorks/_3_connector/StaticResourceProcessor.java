/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._3_connector;

import java.io.IOException;

import com.zgm.howTomcatWorks._3_connector.connector.http.HttpRequest;
import com.zgm.howTomcatWorks._3_connector.connector.http.HttpResponse;

/**
 * 
 * @author 周光明
 * @version $FileName: StaticResourceProcessor.java $Date: 2013-7-22 下午9:50:26
 *          -0400 2013
 * @since 1.0
 * 
 */
public class StaticResourceProcessor {

	public void process(HttpRequest request, HttpResponse response) {
		try {
			response.sendStaticResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}