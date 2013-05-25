/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._7_cancellationAndShutdown._3_handlingAbnormalThreadTermination._0._2_uncaughtExceptionHandlers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: UEHLogger.java $Date: May 24, 2013 9:15:44 AM -0400 2013
 * @since 1.0
 * 
 */
public class UEHLogger implements Thread.UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.SEVERE, "Thread terminated with exception: " + t.getName(), e);
	}
}
