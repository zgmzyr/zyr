/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._11_performanceAndScalability._4_reducingLockContention._1_narrowingLockScope._2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BetterAttributeStore.java $Date: May 28, 2013 1:43:27 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class BetterAttributeStore {
	// @GuardedBy("this")
	private final Map<String, String> attributes = new HashMap<String, String>();

	public boolean userLocationMatches(String name, String regexp) {
		String key = "users." + name + ".location";
		String location;

		synchronized (this) {
			location = attributes.get(key);
		}

		if (location == null)
			return false;
		else
			return Pattern.matches(regexp, location);
	}
}
