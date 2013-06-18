/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._14_buildingCustomSynchronizers._1_managingStateDependence._1_propagatingPreconditionFailureToCallers;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: Jun 13, 2013 9:53:36 AM -0400 2013
 * @since 1.0
 * 
 */
public class UseGrumpyBoundedBuffer {

	private static final long SLEEP_GRANULARITY = 10000;

	public void useGrumpyBoundedBuffer() throws InterruptedException {
		GrumpyBoundedBuffer<Object> buffer = new GrumpyBoundedBuffer<Object>(10);
		while (true) {
			try {
				Object item = buffer.take();
				// use item
				break;
			} catch (BufferEmptyException e) {
				Thread.sleep(SLEEP_GRANULARITY);
			}
		}

	}
}
