package com.zgm.zen.proxy.DynamicCommon;

import java.lang.reflect.InvocationHandler;

public class Client {

	public static void main(String[] args){
		Subject subject = new RealSubject();
		
		InvocationHandler handler = new MyInvocationHandler(subject);
		
		//下面注释的语句为什么报错
//		Subject proxy =   DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), Subject.class.getInterfaces(), handler);
		Subject proxy =   DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
		
		
		proxy.doSomething("Finish!");
		
		System.out.println(subject.getClass().getInterfaces());
		System.out.println(Subject.class.getInterfaces());
	}
}
