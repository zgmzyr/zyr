/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._13_explicitLocks._5_read_writeLocks._0;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ReadWriteMap.java $Date: Jun 9, 2013 2:22:42 PM -0400 2013
 * @since 1.0
 * 
 */
public class ReadWriteMap<K, V> {
	private final Map<K, V> map;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();

	public ReadWriteMap(Map<K, V> map) {
		this.map = map;
	}

	public V put(K key, V value) {
		w.lock();
		try {
			return map.put(key, value);
		} finally {
			w.unlock();
		}
	}

	// Do the same for remove(), putAll(), clear()

	public V get(Object key) {
		r.lock();
		try {
			return map.get(key);
		} finally {
			r.unlock();
		}
	}
	// Do the same for other read-only Map methods
}
