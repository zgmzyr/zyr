/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._2_instanceConfinment._2_trackingFleetVehicles;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: MutablePoint.java $Date: Apr 16, 2013 5:24:36 PM -0400 2013
 * @since 1.0
 * 
 */
//@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
