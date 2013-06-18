/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BaseBoundedBuffer.java $Date: Jun 9, 2013 2:57:35 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public abstract class BaseBoundedBuffer<V> {
	// @GuardedBy("this")
	private final V[] buf;
	// @GuardedBy("this")
	private int tail;
	// @GuardedBy("this")
	private int head;
	// @GuardedBy("this")
	private int count;

	protected BaseBoundedBuffer(int capacity) {
		this.buf = (V[]) new Object[capacity];
	}

	protected synchronized final void doPut(V v) {
		buf[tail] = v;
		if (++tail == buf.length) {
			tail = 0;
		}
		
		++count;
	}

	protected synchronized final V doTake() {
		V v = buf[head];
		buf[head] = null;
		if (++head == buf.length) {
			head = 0;
		}
		
		--count;
		return v;
	}

	public synchronized final boolean isFull() {
		return count == buf.length;
	}

	public synchronized final boolean isEmpty() {
		return count == 0;
	}
}
