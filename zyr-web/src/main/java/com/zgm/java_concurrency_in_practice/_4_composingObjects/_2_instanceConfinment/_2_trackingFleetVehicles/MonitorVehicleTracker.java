/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._2_instanceConfinment._2_trackingFleetVehicles;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于监视器模式的车辆追踪
 * 
 * @author 周光明 Exp
 * @version $FileName: MonitorVehicleTracker.java $Date: Apr 16, 2013 5:21:58 PM -0400 2013
 * @since 1.0
 * 
 */
//@ThreadSafe
public class MonitorVehicleTracker {
//   @GuardedBy("this")
   private final Map<String, MutablePoint> locations;

   public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
       this.locations = deepCopy(locations);
   }

   public synchronized Map<String, MutablePoint> getLocations() {
       return deepCopy(locations);
   }

   public synchronized MutablePoint getLocation(String id) {
       MutablePoint loc = locations.get(id);
       return loc == null ? null : new MutablePoint(loc);
   }

   public synchronized void setLocation(String id, int x, int y) {
       MutablePoint loc = locations.get(id);
       if (loc == null)
           throw new IllegalArgumentException("No such ID: " + id);
       loc.x = x;
       loc.y = y;
   }

   private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
       Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();

       for (String id : m.keySet())
           result.put(id, new MutablePoint(m.get(id)));

       return Collections.unmodifiableMap(result);
   }
}
