/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._10_avoidingLivenessHazards._1_deadlock._3_deadlocksBetweenCooperatingObjects._1_deadLock;

import java.util.HashSet;
import java.util.Set;

import com.zgm.java_concurrency_in_practice._4_composingObjects._3_delegatingThreadSafety._1_usingDelegation.Point;

/**
 * 不要这么做：容易发生死锁
 * 
 * @author 周光明 Exp
 * @version $FileName: Taxi.java $Date: May 27, 2013 3:20:38 PM -0400 2013
 * @since 1.0
 * 
 */
class Taxi {
	// @GuardedBy("this")
	private Point location, destination;
	private final Dispatcher dispatcher;

	public Taxi(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	public synchronized Point getLocation() {
		return location;
	}

	public synchronized void setLocation(Point location) {
		this.location = location;
		if (location.equals(destination))
			dispatcher.notifyAvailable(this);
	}
}

class Dispatcher {
	// @GuardedBy("this")
	private final Set<Taxi> taxis;
	// @GuardedBy("this")
	private final Set<Taxi> availableTaxis;

	public Dispatcher() {
		taxis = new HashSet<Taxi>();
		availableTaxis = new HashSet<Taxi>();
	}

	public synchronized void notifyAvailable(Taxi taxi) {
		availableTaxis.add(taxi);
	}

	public synchronized Image getImage() {
		Image image = new Image();
		for (Taxi t : taxis)
			image.drawMarker(t.getLocation());
		return image;
	}
}
