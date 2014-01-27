/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._3_connector.startup;

import com.zgm.howTomcatWorks._3_connector.connector.http.HttpConnector;

/**
 * 
 * @author 周光明
 * @version $FileName: Bootstrap.java $Date: 2013-7-21 下午9:41:15 -0400 2013
 * @since 1.0
 * 
 */
public class Bootstrap {
	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		connector.start();
	}
}
