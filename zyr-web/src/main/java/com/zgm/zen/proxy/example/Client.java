package com.zgm.zen.proxy.example;

public class Client {

	public static void main(String[] args){
		IGamePlayer gamePlayer = new GamePlayer("张三");
		
		IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
		
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		proxy.login("张三", "");
		
		proxy.killBoss();
		
		proxy.upgrade();
		
	}
	
}
