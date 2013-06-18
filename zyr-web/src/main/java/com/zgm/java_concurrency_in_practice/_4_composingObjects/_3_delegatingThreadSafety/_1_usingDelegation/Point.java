/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._3_delegatingThreadSafety._1_usingDelegation;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Point.java $Date: Apr 17, 2013 1:49:45 PM -0400 2013
 * @since 1.0
 * 
 */
// @Immutable //不可变的
public class Point {

	public final int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point location) {
		this.x = location.x;
		this.y = location.y;
	}
}
