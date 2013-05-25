/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._2_instanceConfinment;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: PersonSet.java $Date: Apr 16, 2013 5:09:36 PM -0400 2013
 * @since 1.0
 * 
 */
//@ThreadSafe  
public class PersonSet {
//    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    interface Person {
    }
}
