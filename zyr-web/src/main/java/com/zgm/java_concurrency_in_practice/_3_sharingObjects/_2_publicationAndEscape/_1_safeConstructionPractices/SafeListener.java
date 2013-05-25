/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._2_publicationAndEscape._1_safeConstructionPractices;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SafeListener.java $Date: Apr 15, 2013 3:22:33 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class SafeListener {
	private final EventListener listener;

	private SafeListener() {
		listener = new EventListener() {
			public void onEvent(Event e) {
				doSomething(e);
			}
		};
	}

	public static SafeListener newInstance(EventSource source) {
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);
		return safe;
	}

	void doSomething(Event e) {
	}

	interface EventSource {
		void registerListener(EventListener e);
	}

	interface EventListener {
		void onEvent(Event e);
	}

	interface Event {
	}
}
