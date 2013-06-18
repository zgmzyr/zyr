/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence._1_propagatingPreconditionFailureToCallers;

import com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence.BaseBoundedBuffer;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GrumpyBoundedBuffer.java $Date: Jun 13, 2013 10:13:19 AM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
	public GrumpyBoundedBuffer(int size) {
		super(size);
	}

	public synchronized void put(V v) throws BufferFullException {
		if (isFull())
			throw new BufferFullException();
		doPut(v);
	}

	public synchronized V take() throws BufferEmptyException {
		if (isEmpty())
			throw new BufferEmptyException();
		return doTake();
	}
}
