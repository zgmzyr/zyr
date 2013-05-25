package com.zgm.zen.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 * @author Administrator
 *
 */
public class GamePlayIH implements InvocationHandler {

	//被代理者
	Class cls = null;
	//被代理的实例
	Object obj = null;
	
	public GamePlayIH(Object obj){
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		Object result = method.invoke(this.obj, args);
		
		if(method.getName().equalsIgnoreCase("login")){
			System.out.println("有人在盗用你的帐号！");
			
		}
		return result;
	}

}
