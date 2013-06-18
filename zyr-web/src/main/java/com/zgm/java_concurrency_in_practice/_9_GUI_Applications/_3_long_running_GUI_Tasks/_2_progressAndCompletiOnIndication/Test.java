/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._3_long_running_GUI_Tasks._2_progressAndCompletiOnIndication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test.java $Date: May 27, 2013 10:39:02 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test {
	ExecutorService backgroundExec = Executors.newCachedThreadPool();
	final JButton startButton = new JButton("开始");
	final JButton cancelButton = new JButton("结束");
	final JLabel label = new JLabel();

	public void runInBackground(final Runnable task) {
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				class CancelListener implements ActionListener {
					BackgroundTask<?> task;

					public void actionPerformed(ActionEvent event) {
						if (task != null)
							task.cancel(true);
					}
				}
				
				final CancelListener listener = new CancelListener();
				listener.task = new BackgroundTask<Void>() {
					public Void compute() {
						while (moreWork() && !isCancelled())
							doSomeWork();
						return null;
					}

					private void doSomeWork() {
						// TODO

					}

					private boolean moreWork() {
						// TODO
						return false;
					}

					public void onCompletion(boolean cancelled, String s, Throwable exception) {
						cancelButton.removeActionListener(listener);
						label.setText("done");
					}

					@Override
					public void run() {
						// TODO

					}

					@Override
					public boolean cancel(boolean mayInterruptIfRunning) {
						// TODO
						return false;
					}

					@Override
					public boolean isCancelled() {
						// TODO
						return false;
					}

					@Override
					public boolean isDone() {
						// TODO
						return false;
					}

					@Override
					public Void get() throws InterruptedException, ExecutionException {
						// TODO
						return null;
					}

					@Override
					public Void get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException,
							TimeoutException {
						// TODO
						return null;
					}
				};
				cancelButton.addActionListener(listener);
				backgroundExec.execute(task);
			}
		});
	}

}
