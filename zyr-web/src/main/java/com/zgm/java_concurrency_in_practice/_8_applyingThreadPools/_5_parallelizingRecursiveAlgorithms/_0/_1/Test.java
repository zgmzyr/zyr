/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._8_applyingThreadPools._5_parallelizingRecursiveAlgorithms._0._1;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 24, 2013 2:55:57 PM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	void processSequentially(List<Element> elements) {
		for (Element e : elements)
			process(e);
	}

	void processInParallel(Executor exec, List<Element> elements) {
		for (final Element e : elements)
			exec.execute(new Runnable() {
				public void run() {
					process(e);
				}
			});
	}
	
	private void process(Element e) {
		// TODO

	}
}
