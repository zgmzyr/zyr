package com.zgm.test;

/**
 * @author zhouguangming
 *  创建时间: 2014年5月23日 下午4:49:23
 */
public class Location {
	public void getInfo() {
		String location = "";
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		location = "类名：" + stacks[2].getClassName() + "\n函数名：" + stacks[2].getMethodName()
				+ "\n文件名：" + stacks[2].getFileName() + "\n行号："
				+ stacks[2].getLineNumber() + "";
		System.out.println(location);
	}
}
