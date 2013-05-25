package com.zgm.zen.proxy.DynamicCommon;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {
	
	public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
		
		if(true){
			(new BeforeAdvice()).exec();
		}
		
		return (T) Proxy.newProxyInstance(loader, interfaces, h);
	}
	
	

}
