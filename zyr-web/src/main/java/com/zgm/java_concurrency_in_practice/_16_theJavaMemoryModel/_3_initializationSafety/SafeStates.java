/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._3_initializationSafety;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SafeStates.java $Date: Jun 18, 2013 3:43:22 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class SafeStates {
	private final Map<String, String> states;

	public SafeStates() {
		states = new HashMap<String, String>();
		states.put("alaska", "AK");
		states.put("alabama", "AL");
		// ...
		states.put("wyoming", "WY");
	}

	public String getAbbreviation(String s) {
		return states.get(s);
	}
}
