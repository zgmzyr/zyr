package com.zgm.zen.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args){
		IGamePlayer player = new GamePlayer("张三");
		
		InvocationHandler handler = new GamePlayIH(player);
		
		ClassLoader cl = player.getClass().getClassLoader();
		
		IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
		
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		proxy.login("张三", "");
		
		proxy.killBoss();
		
		proxy.upgrade();
		
	}
	
}
