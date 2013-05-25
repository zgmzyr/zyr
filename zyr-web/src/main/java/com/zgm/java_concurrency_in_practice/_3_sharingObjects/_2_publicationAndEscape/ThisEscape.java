/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._2_publicationAndEscape;

/**
 * 隐式的使this引用逸出（不要这么做） 
 * 
 * @author 周光明 Exp
 * @version $FileName: ThisEscape.java $Date: Apr 15, 2013 3:01:11 PM -0400 2013
 * @since 1.0
 * 
 */
public class ThisEscape {

	public ThisEscape(EventSource source) {
		source.registerListener(new EventListener() {
			public void onEvent(Event e) {
				doSomething(e);
			}
		});
	}
	
//	public static void main() {
	public static void main(String[] args) {
		new ThisEscape(new EventSource() {

			@Override
			public void registerListener(EventListener e) {
				
				System.out.println("注册监听器....");
			}
			
		});
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
