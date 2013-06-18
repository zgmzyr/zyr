/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._11_performanceAndScalability._4_reducingLockContention._2_reducingLockGranularity._1;

import java.util.Set;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ServerStatus.java $Date: May 28, 2013 2:00:51 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class ServerStatus {
	// @GuardedBy("this")
	public final Set<String> users;

	// @GuardedBy("this")
	public final Set<String> queries;

	public ServerStatus(Set<String> users, Set<String> queries) {
		super();
		this.users = users;
		this.queries = queries;
	}
	
	// ...
	public synchronized void addUser(String u) {
		users.add(u);
	}

	public synchronized void addQuery(String q) {
		queries.add(q);
	}

	public synchronized void removeUser(String u) {
		users.remove(u);
	}

	public synchronized void removeQuery(String q) {
		queries.remove(q);
	}
}
