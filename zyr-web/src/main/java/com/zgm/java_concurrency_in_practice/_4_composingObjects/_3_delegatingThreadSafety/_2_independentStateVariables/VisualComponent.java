/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.java_concurrency_in_practice._4_composingObjects._3_delegatingThreadSafety._2_independentStateVariables;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: VisualComponent.java $Date: Apr 17, 2013 2:17:03 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class VisualComponent {
	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<KeyListener>();
	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListener>();

	public void addKeyListener(KeyListener listener) {
		keyListeners.add(listener);
	}

	public void addMouseListener(MouseListener listener) {
		mouseListeners.add(listener);
	}

	public void removeKeyListener(KeyListener listener) {
		keyListeners.remove(listener);
	}

	public void removeMouseListener(MouseListener listener) {
		mouseListeners.remove(listener);
	}
}
