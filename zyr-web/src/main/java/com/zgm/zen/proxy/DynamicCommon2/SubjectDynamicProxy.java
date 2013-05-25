package com.zgm.zen.proxy.DynamicCommon2;

import java.lang.reflect.InvocationHandler;


public class SubjectDynamicProxy extends DynamicProxy {

	public static <T> T newProxyInstance(Subject subject){
		
		ClassLoader loader = subject.getClass().getClassLoader();
		Class<?>[] classes = subject.getClass().getInterfaces();
		
		InvocationHandler handler = new MyInvocationHandler(subject);
		
		return DynamicProxy.newProxyInstance(loader, classes, handler);
	}
}
