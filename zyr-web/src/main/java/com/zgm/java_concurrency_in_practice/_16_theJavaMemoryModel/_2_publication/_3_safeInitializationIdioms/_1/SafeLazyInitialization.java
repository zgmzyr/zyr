/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._3_safeInitializationIdioms._1;

import com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._1_unsafePublication.Resource;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SafeLazyInitialization.java $Date: Jun 18, 2013 2:16:15 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class SafeLazyInitialization {
	private static Resource resource;

	public synchronized static Resource getInstance() {
		if (resource == null) {
			resource = new Resource();
		}
		
		return resource;
	}
}
