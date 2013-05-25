/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._3._1_fileChannel._2_fileDateTransfer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LoadWebPage.java $Date: Mar 30, 2013 4:14:34 PM -0400
 *          2013
 * @since 1.0
 * 
 */
public class LoadWebPage {
	public void loadWebPage(String url) throws IOException {
		try (FileChannel destChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE)) {
			InputStream input = new URL(url).openStream();
			ReadableByteChannel srcChannel = Channels.newChannel(input);
			destChannel.transferFrom(srcChannel, 0, Integer.MAX_VALUE);
		}
	}

	public static void main(String[] args) throws IOException {
		LoadWebPage lwp = new LoadWebPage();
		lwp.loadWebPage("http://www.baidu.com");
	}
}
