/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._3._1_fileChannel._4_lockFile;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: LockUsage.java $Date: Apr 3, 2013 2:10:22 PM -0400 2013
 * @since 1.0
 * 
 */
public class LockUsage {
	public static void main(String[] args) throws IOException {
		LockUsage lu = new LockUsage();
		lu.updateWithLock();
	}

	private void updateWithLock() throws IOException {
		String srcFilename = "understandingTheJava7/third_io/_3/_1_fileChannel/src.txt";
		try (FileChannel fileChannel = FileChannel.open(Paths.get(srcFilename), StandardOpenOption.READ,
				StandardOpenOption.WRITE)) {
//			fileChannel.lock();
			fileChannel.lock(0, 11, false);
			//TODO 相关文件操作
		}
	}
}
