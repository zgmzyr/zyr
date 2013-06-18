/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._1._2_threadConfinementInSwing;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: GuiExecutor.java $Date: May 27, 2013 9:44:20 AM -0400 2013
 * @since 1.0
 * 
 */
public class GuiExecutor extends AbstractExecutorService {
	// Singletons have a private constructor and a public factory
	private static final GuiExecutor instance = new GuiExecutor();

	private GuiExecutor() {
	}

	public static GuiExecutor instance() {
		return instance;
	}

	public void execute(Runnable r) {
		if (SwingUtilities.isEventDispatchThread())
			r.run();
		else
			SwingUtilities.invokeLater(r);
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO
		return false;
	}

	@Override
	public boolean isShutdown() {
		// TODO
		return false;
	}

	@Override
	public boolean isTerminated() {
		// TODO
		return false;
	}

	@Override
	public void shutdown() {
		// TODO

	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO
		return null;
	}

	// Plus trivial implementations of lifecycle methods
}
