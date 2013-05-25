/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._4_NIO2._1_fileSystemCall._5_watch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: WatchAndCalculate.java $Date: Apr 7, 2013 5:39:50 PM
 *          -0400 2013
 * @since 1.0
 * 
 */
public class WatchAndCalculate {
	public void calculate() throws IOException, InterruptedException {
		WatchService service = FileSystems.getDefault().newWatchService();
		Path path = Paths.get("").toAbsolutePath();
		path.register(service, StandardWatchEventKinds.ENTRY_CREATE);
		while (true) {
			WatchKey key = service.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				Path createdPath = (Path) event.context();
				createdPath = path.resolve(createdPath);
				long size = Files.size(createdPath);
				System.out.println(createdPath + " ==> " + size);
			}
			key.reset();
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws Throwable {
		WatchAndCalculate wc = new WatchAndCalculate();
		wc.calculate();
	}
}
