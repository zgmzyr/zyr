/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._3_long_running_GUI_Tasks._0;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.zgm.java_concurrency_in_practice._9_GUI_Applications._1._2_threadConfinementInSwing.GuiExecutor;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: Test2.java $Date: May 27, 2013 10:17:51 AM -0400 2013
 * @since 1.0
 * 
 */
public class Test2 {
	ExecutorService backgroundExec = Executors.newCachedThreadPool();
	final JButton button = new JButton("长时间运行的任务");
	final JLabel label = new JLabel();

	public void runInBackground() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setEnabled(false);
				label.setText("busy");
				backgroundExec.execute(new Runnable() {
					public void run() {
						try {
							doBigComputation();
						} finally {
							GuiExecutor.instance().execute(new Runnable() {
								public void run() {
									button.setEnabled(true);
									label.setText("idle");
								}
							});
						}
					}

					private void doBigComputation() {
						//TODO
						
					}
				});
			}
		});

	}

}
