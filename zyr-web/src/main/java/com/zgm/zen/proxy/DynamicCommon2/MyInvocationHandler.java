package com.zgm.zen.proxy.DynamicCommon2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object target = null;
	
	public MyInvocationHandler(Object target){
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = method.invoke(this.target, args);
		
		return result;
	}
	
}
