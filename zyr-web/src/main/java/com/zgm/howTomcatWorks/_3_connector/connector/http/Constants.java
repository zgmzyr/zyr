/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * 
 */
package com.zgm.howTomcatWorks._3_connector.connector.http;

import java.io.File;

/**
 * 
 * @author 周光明
 * @version $FileName: Constants.java $Date: 2013-7-22 下午9:55:02 -0400 2013
 * @since 1.0
 * 
 */
public final class Constants {
	  public static final String WEB_ROOT =
	    System.getProperty("user.dir") + File.separator  + "webroot";
//	  public static final String Package = "ex03.pyrmont.connector.http";
	  public static final String Package = "com.zgm.howTomcatWorks._3_connector.connector.http";
	  public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
	  public static final int PROCESSOR_IDLE = 0;
	  public static final int PROCESSOR_ACTIVE = 1;
	}
