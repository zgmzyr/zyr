/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._4_addingFunctionalityToExistingThreadSafeClasses._1_clientSideLocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: ListHelper2.java $Date: May 14, 2013 3:32:18 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe //TODO, 中所以是线程安全的：是因为状态都是用同一个锁来保护的
public class ListHelper2<E> {
	
	//TODO: list 是public级别
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());

	//..... 省略其它方法
	
	public boolean putIfAbsent(E x) {
		synchronized (list) {
			boolean absent = !list.contains(x);
			if (absent)
				list.add(x);
			return absent;
		}
	}
}
