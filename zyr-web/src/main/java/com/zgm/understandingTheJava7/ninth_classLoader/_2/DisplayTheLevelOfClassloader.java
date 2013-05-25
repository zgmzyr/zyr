/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._2;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: DisplayTheLevelOfClassloader.java $Date: 2013-3-18
 *          下午8:45:23 -0400 2013
 * @since 1.0
 * 
 */
public class DisplayTheLevelOfClassloader {
	public static void main(String[] args) {
		new DisplayTheLevelOfClassloader().displayParnets();
	}
	
	public void displayParnets() {
		ClassLoader currentClassLoader = this.getClass().getClassLoader();
		
		while (currentClassLoader != null) {
			System.out.println(currentClassLoader.toString());
			
			currentClassLoader = currentClassLoader.getParent();
		}
		
	}
}
