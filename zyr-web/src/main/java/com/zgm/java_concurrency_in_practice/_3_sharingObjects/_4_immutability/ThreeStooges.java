/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._3_sharingObjects._4_immutability;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
/**
 * 在可变对象基础上构建不可变类
 * 
 * @author 周光明 Exp
 * @version $FileName: ThreeStooges.java $Date: Apr 16, 2013 1:52:21 PM -0400 2013
 * @since 1.0
 * 
 */
//@Immutable //不可变的
public final class ThreeStooges {
   private final Set<String> stooges = new HashSet<String>();

   public ThreeStooges() {
       stooges.add("Moe");
       stooges.add("Larry");
       stooges.add("Curly");
   }

   public boolean isStooge(String name) {
       return stooges.contains(name);
   }

   public String getStoogeNames() {
       List<String> stooges = new Vector<String>();
       stooges.add("Moe");
       stooges.add("Larry");
       stooges.add("Curly");
       return stooges.toString();
   }
}
