/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._3_long_running_GUI_Tasks._1_cancellation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JButton;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 27, 2013 10:23:46 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	ExecutorService backgroundExec = Executors.newCachedThreadPool();
	Future<?> runningTask = null; // thread-confined
	final JButton startButton = new JButton("开始");
	final JButton cancelButton = new JButton("结束");

	public void runInBackground() {
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (runningTask != null) { //TOTO 是不是应该是：(runningTask == null) ?
					runningTask = backgroundExec.submit(new Runnable() {
						public void run() {
							while (moreWork()) {
								if (Thread.currentThread().isInterrupted()) {
									cleanUpPartialWork();
									break;
								}
								doSomeWork();
							}
						}

						private void doSomeWork() {
							//TODO
							
						}

						private void cleanUpPartialWork() {
							//TODO
							
						}

						private boolean moreWork() {
							//TODO
							return false;
						}
					});
				}
				;
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (runningTask != null)
					runningTask.cancel(true);
			}
		});

	}

}
