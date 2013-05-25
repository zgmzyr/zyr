/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online at
 * http://www.etong.com/
 */
package com.zgm.understandingTheJava7.third_io._3._1_fileChannel._3_memoryMapFile.copy;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FileMapping.java $Date: Apr 3, 2013 10:32:39 AM -0400
 *          2013
 * @since 1.0
 * 
 */
public class FileMapping {

	public void mapFile() throws IOException {
		String srcFilename = "understandingTheJava7/third_io/_3/_1_fileChannel/src.txt";
		try (FileChannel fileChannel = FileChannel.open(Paths.get(srcFilename), StandardOpenOption.READ,
				StandardOpenOption.WRITE)) {

			MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileChannel.size());
//			Byte b = mappedByteBuffer.get(1024 * 1024);
			Byte b = mappedByteBuffer.get(1024);
//			mappedByteBuffer.put(5 * 1024 * 1024, b);
			mappedByteBuffer.put(0, b);
			
			mappedByteBuffer.force();
		}
	}
	
	public static void main(String[] args) throws IOException {
		FileMapping fm = new FileMapping();
		fm.mapFile();
	}
}
