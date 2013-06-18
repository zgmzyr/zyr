/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._11_performanceAndScalability._4_reducingLockContention._3_lockStriping;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: StripedMap.java $Date: May 28, 2013 2:15:38 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class StripedMap {
	// Synchronization policy: buckets[n] guarded by locks[n%N_LOCKS]
	private static final int N_LOCKS = 16;
	private final Node[] buckets;
	private final Object[] locks;

	private static class Node {
		public Object key;
		public Node next;
		public Object value;

	}

	public StripedMap(int numBuckets) {
		buckets = new Node[numBuckets];
		locks = new Object[N_LOCKS];
		for (int i = 0; i < N_LOCKS; i++)
			locks[i] = new Object();
	}

	private final int hash(Object key) {
		return Math.abs(key.hashCode() % buckets.length);
	}

	public Object get(Object key) {
		int hash = hash(key);
		synchronized (locks[hash % N_LOCKS]) {
			for (Node m = buckets[hash]; m != null; m = m.next)
				if (m.key.equals(key))
					return m.value;
		}
		return null;
	}

	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			synchronized (locks[i % N_LOCKS]) {
				buckets[i] = null;
			}
		}
	}
	// ...
}
