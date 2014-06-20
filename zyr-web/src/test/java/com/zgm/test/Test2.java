package com.zgm.test;

/**
 * @author zhouguangming 
 * 创建时间: 2014年5月23日 下午4:50:00
 */
public class Test2 {
	public static void main(String[] args) {
		BaseResult l = new BaseResult();
		l.getInfo();
	}
}

class BaseResult {
	public void getInfo() {
		String location = "";
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		location = "类名：" + stacks[2].getClassName() + "\n函数名：" + stacks[2].getMethodName()
				+ "\n文件名：" + stacks[2].getFileName() + "\n行号："
				+ stacks[2].getLineNumber() + "";
		System.out.println(location);
	}
}
