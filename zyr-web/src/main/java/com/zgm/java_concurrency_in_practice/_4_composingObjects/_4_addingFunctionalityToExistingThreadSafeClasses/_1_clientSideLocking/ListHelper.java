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
 * @version $FileName: ListHelper.java $Date: May 14, 2013 3:19:21 PM -0400 2013
 * @since 1.0
 * 
 */
// @NotThreadSafe //TODO 不要这么做: 状态不是由同一个锁保护
public class ListHelper<E> {
	//TODO: list 是public级别哦,如果是私有类型的话，是线程安全的，因list变量不会逸出对象
	public List<E> list = Collections.synchronizedList(new ArrayList<E>());

	public synchronized boolean putIfAbsent(E x) {
		boolean absent = !list.contains(x);
		if (absent)
			list.add(x);
		return absent;
	}
}
