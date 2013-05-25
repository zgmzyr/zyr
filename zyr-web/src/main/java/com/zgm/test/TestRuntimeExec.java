/*
 * Copyright 2012 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.test;
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: TestRuntimeExec.java $Date: 2012-12-16 上午11:49:48 -0400 2012
 * @since 1.0
 * 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestRuntimeExec {

    public static void main(String[] args) {

//        test1();
    	test2();
    }

	private static void test1() {
		// 线程里执行command命令
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Process process = Runtime.getRuntime().exec("cmd /c dir");
                    InputStream in = process.getInputStream();
                    BufferedReader inr = new BufferedReader(
                            new InputStreamReader(in, "GBK"));
                    String line = null;
                    while ((line = inr.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        try {
            // (1)让主线程让一次CPU时间
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程继续做自己的事
        for (int i = 0; i < 50; i++) {
            System.out.println("" + i);
        }
	}
	
	private static void test2() {
		
		 try {
             Process process = Runtime.getRuntime().exec("CMD /c dir");
//			 Process process = Runtime.getRuntime().exec("CMD /c del d:/a.txt"); //不能执行成功
//			 Process process = Runtime.getRuntime().exec("CMD /c del a.txt"); //能执行成功
             InputStream in = process.getInputStream();
             BufferedReader inr = new BufferedReader(
                     new InputStreamReader(in, "GBK"));
             String line = null;
             while ((line = inr.readLine()) != null) {
                 System.out.println(line);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
	}
}




