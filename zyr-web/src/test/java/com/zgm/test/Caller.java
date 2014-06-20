package com.zgm.test;

/**
 * @author zhouguangming 
 * 创建时间: 2014年5月23日 下午4:35:53
 */
public class Caller
{
	public static void main(String[] args)
	{
		System.setSecurityManager(new MySecurityManager());
		new A().method();
	}
}

class MySecurityManager extends SecurityManager
{
	protected Class[] getClassContext() {
		return super.getClassContext();
	}
};

class A
{
	void method() {
		new BaseResult().method();
	}
}

class BaseResult
{
	void method() {
		MySecurityManager sm = (MySecurityManager) System.getSecurityManager();
		Class[] cls = sm.getClassContext();
		// for(int i=0;i<cls.length;i++) System.out.println(cls[i]);
		System.out.println(cls[2] + " is Calling me");
	}
}
