/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._9_GUI_Applications._3_long_running_GUI_Tasks._2_progressAndCompletiOnIndication;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.zgm.java_concurrency_in_practice._9_GUI_Applications._1._2_threadConfinementInSwing.GuiExecutor;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: BackgroundTask.java $Date: May 27, 2013 10:34:59 AM -0400 2013
 * @since 1.0
 * 
 */
abstract class BackgroundTask<V> implements Runnable, Future<V> {
    private final FutureTask<V> computation = new Computation();

    private class Computation extends FutureTask<V> {
        public Computation() {
            super(new Callable<V>() {
                public V call() throws Exception {
                    return BackgroundTask.this.compute() ;
                }
            });
        }
        protected final void done() {
            GuiExecutor.instance().execute(new Runnable() {
                public void run() {
                    V value = null;
                    Throwable thrown = null;
                    boolean cancelled = false;
                    try {
                        value = get();
                    } catch (ExecutionException e) {
                        thrown = e.getCause();
                    } catch (CancellationException e) {
                        cancelled = true;
                    } catch (InterruptedException consumed) {
                    } finally {
                        onCompletion(value, thrown, cancelled);
                    }
                };
            });
        }
    }
    protected void setProgress(final int current, final int max) {
        GuiExecutor.instance().execute(new Runnable() {
            public void run() { onProgress(current, max); }
        });
    }
    // Called in the background thread
    protected abstract V compute()  throws Exception;
    // Called in the event thread
    protected void onCompletion(V result, Throwable exception,
                                     boolean cancelled)  { }
    protected void  onProgress(int current, int max)  { }
    // Other Future methods forwarded to computation
}


