/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._122;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: UseExceptionHandlerToPromptSystemReliable.java $Date: 2012-5-13 下午9:01:43 -0400 2012
 * @since 1.0
 * 
 */
public class UseExceptionHandlerToPromptSystemReliable implements Runnable {

	public UseExceptionHandlerToPromptSystemReliable() {
		Thread t = new Thread(this);
		t.setUncaughtExceptionHandler(new ExceptionHandler());
		t.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				
				System.out.println("系统正常运行： " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		throw new RuntimeException();
	}
	
	private static class ExceptionHandler implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			System.out.println("线程" + t.getName() + "出现异常，自行重启，请分析原因。");
			e.printStackTrace();
			
			//重启线程，保证业务不中断
			new UseExceptionHandlerToPromptSystemReliable();
		}
	}
	
	public static void main(String[] args) {
		new UseExceptionHandlerToPromptSystemReliable();
	}
}
