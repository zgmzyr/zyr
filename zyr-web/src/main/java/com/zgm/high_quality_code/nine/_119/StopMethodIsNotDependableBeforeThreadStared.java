/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.high_quality_code.nine._119;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: StopMethodIsNotDependableBeforeThreadStared.java $Date: 2012-5-13 上午10:02:18 -0400 2012
 * @since 1.0
 * 
 */
public class StopMethodIsNotDependableBeforeThreadStared {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		notRecommend();
		recommend();
	}

	private static void notRecommend() {
		while (true) {
			SpamMachine sm = new SpamMachine();
			
			if (!false) {
				sm.stop();
			}
			System.out.println("执行中....");
			sm.start();
		}
	}
	
	private static void recommend() {
		while (true) {
			
			if (!false) {
				new SpamMachine().start();
			}
			
			System.out.println("执行中....");
		}
	}

}
