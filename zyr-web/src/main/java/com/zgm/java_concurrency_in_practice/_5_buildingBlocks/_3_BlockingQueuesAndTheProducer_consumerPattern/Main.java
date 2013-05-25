/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._3_BlockingQueuesAndTheProducer_consumerPattern;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Main.java $Date: May 15, 2013 3:46:58 PM -0400 2013
 * @since 1.0
 * 
 */
public class Main {
	private static final int N_CONSUMERS = 5;
	private static final int BOUND = 10;
	
	public static void main(String[] args) {
		File[] roots = null;//TODO
		startIndexing(roots);
	}

	public static void startIndexing(File[] roots) {
		BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
		FileFilter filter = new FileFilter() {
			public boolean accept(File file) {
				return true;
			}
		};

		for (File root : roots) {
			new Thread(new FileCrawler(queue, filter, root)).start();
		}

		for (int i = 0; i < N_CONSUMERS; i++) {
			new Thread(new Indexer(queue)).start();
		}
	}
}
