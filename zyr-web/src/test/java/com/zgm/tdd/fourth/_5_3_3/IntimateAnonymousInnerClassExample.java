package com.zgm.tdd.fourth._5_3_3;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class IntimateAnonymousInnerClassExample {

	private StartStopSynchronisedThread thread;
	
	@Test
	public void testStartingAndStopingThreadsThroughAnExecutorService() throws Exception {
		Server server = new Server();
		
		server.setThreadFactory(new ThreadFactory() {
			public Thread newThread(Runnable task) {
				thread = new StartStopSynchronisedThread(task);
				
				return thread;
			}
		});
		
		server.start();
		thread.shouldBeStartedWithin(1, TimeUnit.SECONDS);
		server.stop();
		thread.shouldBeStoppedWithin(1, TimeUnit.SECONDS);
	}
}
