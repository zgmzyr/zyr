package com.zgm.zen.proxy.forceProxy;

/**
 * 直接访问真实角色
 * @author Administrator
 *
 */
public class Client {

	public static void main(String[] args){
		IGamePlayer gamePlayer = new GamePlayer("张三");
		
//		IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
		
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		gamePlayer.login("张三", "");
		
		gamePlayer.killBoss();
		
		gamePlayer.upgrade();
		
	}
	
}
