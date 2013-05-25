/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._1_synchronizedCollections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 隐藏的迭代器（不要这么做）
 * 
 * @author 周光明 Exp
 * @version $FileName: HiddenIterator.java $Date: May 15, 2013 2:15:45 PM -0400 2013
 * @since 1.0
 * 
 */

public class HiddenIterator {
//    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<Integer>();

    public synchronized void add(Integer i) { set.add(i); }
    public synchronized void remove(Integer i) { set.remove(i); }

    //TODO 没有加synchronized关键字，非线程安全的  （不要这么做）
    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        
        //TODO 输出set时，会用Iterator迭代输出 (集合的hashCode、equals 等方法都会使用Iterator)
        System.out.println("DEBUG: added ten elements to " + set);
   }
}



