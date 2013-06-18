/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._11_performanceAndScalability._4_reducingLockContention._2_reducingLockGranularity._2;

import java.util.Set;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ServerStatus.java $Date: May 28, 2013 2:06:33 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class ServerStatus {
	// @GuardedBy("users")
	public final Set<String> users;
	// @GuardedBy("queries")
	public final Set<String> queries;

	public ServerStatus(Set<String> users, Set<String> queries) {
		super();
		this.users = users;
		this.queries = queries;
	}

	// ...
	public void addUser(String u) {
		synchronized (users) {
			users.add(u);
		}
	}

	public void addQuery(String q) {
		synchronized (queries) {
			queries.add(q);
		}
	}
	// remove methods similarly refactored to use split locks
}
