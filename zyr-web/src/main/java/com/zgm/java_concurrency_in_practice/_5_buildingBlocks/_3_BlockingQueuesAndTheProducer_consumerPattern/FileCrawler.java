/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._3_BlockingQueuesAndTheProducer_consumerPattern;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FileCrawler.java $Date: May 15, 2013 3:19:50 PM -0400 2013
 * @since 1.0
 * 
 */
public class FileCrawler implements Runnable {
	private final BlockingQueue<File> fileQueue;
	private final FileFilter fileFilter;
	private final File root;

	public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
		super();
		this.fileQueue = fileQueue;
		this.fileFilter = fileFilter;
		this.root = root;
	}

	// ...
	public void run() {
		try {
			crawl(root);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void crawl(File root) throws InterruptedException {
		File[] entries = root.listFiles(fileFilter);
		if (entries != null) {
			for (File entry : entries)
				if (entry.isDirectory())
					crawl(entry);
				else if (!alreadyIndexed(entry))
					fileQueue.put(entry);
		}
	}

	private boolean alreadyIndexed(File entry) {
		// TODO
		return false;
	}
}
