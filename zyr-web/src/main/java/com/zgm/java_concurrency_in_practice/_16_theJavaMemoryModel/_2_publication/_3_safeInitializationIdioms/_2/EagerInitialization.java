/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._3_safeInitializationIdioms._2;

import com.zgm.java_concurrency_in_practice._16_theJavaMemoryModel._2_publication._1_unsafePublication.Resource;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: EagerInitialization.java $Date: Jun 18, 2013 2:21:37 PM -0400 2013
 * @since 1.0
 * 
 */
// @ThreadSafe
public class EagerInitialization {
	/*
	 * 
	 * 由于类加载的初始化阶段会获取 EagerInitialization.class这个锁，并且每个线程在执行前都至少获取EagerInitialization.class
	 * 这个锁以确保这个类已经加载，这样就自动保证了resource 对所有线程可见，然而，这个规则仅仅适用于在构造时的状态,如果Resource 是可变的， 
	 * 仍然需要同步来确保随后的修改操作是可见的
	 */
	private static Resource resource = new Resource();

	public static Resource getResource() {
		return resource;
	}
}
