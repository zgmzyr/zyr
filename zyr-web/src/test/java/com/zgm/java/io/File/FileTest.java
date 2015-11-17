package com.zgm.java.io.File;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTest {

	@Test
	public void test() throws IOException {
//		File file = new File("/home/zgm/test/abc", "a.txt");
		File file = new File("/home/zgm/test/abc/a.txt");
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			assertTrue(file.createNewFile());
		}
	}
}
