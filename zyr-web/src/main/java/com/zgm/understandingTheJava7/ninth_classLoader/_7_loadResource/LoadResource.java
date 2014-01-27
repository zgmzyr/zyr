/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.ninth_classLoader._7_loadResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LoadResource.java $Date: 2013-3-31 上午9:17:38 -0400 2013
 * @since 1.0
 * 
 */
public class LoadResource {
	public void loadConfig() throws IOException {
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream input = loader
				.getResourceAsStream("com/zgm/understandingTheJava7/ninth_classLoader/_7_loadResource/config.properties");
		if (input == null) {
			throw new IOException("找不到配置文件。");
		}

		this.printInformation(input);
	}

	public void loadConfig2() throws IOException {
		ClassLoader loader = this.getClass().getClassLoader();
		URL url = loader
				.getResource("com/zgm/understandingTheJava7/ninth_classLoader/_7_loadResource/config.properties");
		InputStream input = url.openStream();
		if (input == null) {
			throw new IOException("找不到配置文件。");
		}

		this.printInformation(input);
	}

	public void loadConfigFromClass() throws IOException {
		URL url = this.getClass().getResource("config.properties");
		InputStream input = url.openStream();

		this.printInformation(input);
	}

	public void loadConfigFromClass2() throws IOException {
		InputStream input = this.getClass().getResourceAsStream(
				"config.properties");

		this.printInformation(input);
	}

	private void printInformation(InputStream input) throws IOException {
		Properties props = new Properties();
		props.load(input);
		System.out.println(props.getProperty("name"));
	}

	public static void main(String[] args) throws IOException {
		LoadResource lr = new LoadResource();
		lr.loadConfig();
		lr.loadConfig2();
		lr.loadConfigFromClass();
		lr.loadConfigFromClass2();
	}
}
