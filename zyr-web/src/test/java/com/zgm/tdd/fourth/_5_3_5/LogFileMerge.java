package com.zgm.tdd.fourth._5_3_5;


/**
 * 测试模式 ：
 * 5. 额外的构造函数
 *  @author zgm
 *
 */
public class LogFileMerge {

	private URL logFileA, logFileB;
	
	public LogFileMerge() {
		this(new URL("http://server1/system.log"),
				new URL("http://server2/system.log"));
		
		
	}

	public LogFileMerge(URL a, URL b) {
		this.logFileA = a;
		this.logFileB = b;
	}
}
