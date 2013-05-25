package com.zgm.zen.proxy.forceProxy;

/**
 * 本例使用的是强制代理
 * 
 * 注：普通代理：我们要知道代理的存在，也就是类似GamePlayerProxy的存在，然后 才能访问。
 * 	   强制代理：调用者直接调用真实角色，而不用关心代理是否存在，其代理的产生是由真实角色
 * 				 决定的,即要从真实的角色查找到代理角色	
 * @author Administrator
 *
 */
public class Client3 {

	public static void main(String[] args){
		IGamePlayer gamePlayer = new GamePlayer("张三");
		
//		IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
		IGamePlayer proxy = gamePlayer.getProxy();
		
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		proxy.login("张三", "");
		
		proxy.killBoss();
		
		proxy.upgrade();
		
	}
	
}
