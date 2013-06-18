/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._1_unsafePublication;

/**
 * 不要这么做：
 * 
 * @author 周光明 Exp
 * @version $FileName: UnsafeLazyInitialization.java $Date: Jun 18, 2013 2:03:33 PM -0400 2013
 * @since 1.0
 * 
 */
// @NotThreadSafe
public class UnsafeLazyInitialization {
	//注：如果Resource是不可变类，则UnsafeLazyInitialization是线程安全的
	private static Resource resource;

	public static Resource getInstance() {
		if (resource == null) {
			resource = new Resource(); // unsafe publication
		}
		
		return resource;
	}
}
