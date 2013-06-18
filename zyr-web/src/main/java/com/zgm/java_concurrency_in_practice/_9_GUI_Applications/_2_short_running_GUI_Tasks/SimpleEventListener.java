/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._2_short_running_GUI_Tasks;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SimpleEventListener.java $Date: May 27, 2013 9:58:46 AM -0400 2013
 * @since 1.0
 * 
 */
public class SimpleEventListener {
	final Random random = new Random();
	final JButton button = new JButton("Change Color");

	public void addActionListener() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(new Color(random.nextInt()));
			}
		});

	}
}
