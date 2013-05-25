/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.java_concurrency_in_practice._6_taskExecution._2_theExecutorFramework._5_delayedAndPeriodicTasks;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 应该用ScheduledThreadPoolExecutor代替Timer
 * 
 * @author 周光明 Exp
 * @version $FileName: OutOfTime.java $Date: May 17, 2013 3:21:29 PM -0400 2013
 * @since 1.0
 * 
 */
public class OutOfTime {
    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
//        SECONDS.sleep(1);
        Thread.sleep(1000);
        timer.schedule(new ThrowTask(), 1);
//        SECONDS.sleep(5);
        Thread.sleep(5000);
    }

    static class ThrowTask extends TimerTask {
        public void run() {
            throw new RuntimeException();
        }
    }
}
