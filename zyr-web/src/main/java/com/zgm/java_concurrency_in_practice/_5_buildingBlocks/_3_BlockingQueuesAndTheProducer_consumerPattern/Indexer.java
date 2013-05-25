/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._5_buildingBlocks._3_BlockingQueuesAndTheProducer_consumerPattern;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Indexer.java $Date: May 15, 2013 3:21:17 PM -0400 2013
 * @since 1.0
 * 
 */
public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true)
                indexFile(queue.take());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

	private void indexFile(File take) {
		//TODO
		
	}
}
