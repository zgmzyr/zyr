/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._4_double_checkedLocking;

import com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._1_unsafePublication.Resource;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: DoubleCheckedLocking.java $Date: Jun 18, 2013 2:50:56 PM -0400 2013
 * @since 1.0
 * 
 */
// @NotThreadSafe
public class DoubleCheckedLocking {
	private static Resource resource;

	public static Resource getInstance() {
		//还是存在可见性问题
		if (resource == null) {
			synchronized (DoubleCheckedLocking.class) {
				if (resource == null)
					resource = new Resource();
			}
		}
		
		return resource;
	}
}
