package com.zgm.zen.proxy.forceProxy;

/**
 * 直接访问代理
 * @author Administrator
 *
 */
public class Client2 {

	public static void main(String[] args){
		IGamePlayer gamePlayer = new GamePlayer("张三");
		
		IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
		
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		proxy.login("张三", "");
		
		proxy.killBoss();
		
		proxy.upgrade();
		
	}
	
}
