package com.zgm.zen.proxy.commonProxy;

/**
 * 本例使用的是普通代理,在Example基础上仅仅修改了构造函数，传递进来一个被代理者的名称，即可进行代理，在这种
 * 情况下，调用者只需知道代理的存在即可，不用知道代理了谁，同时场景类也稍作修改
 * 
 * 注：普通代理：我们要知道代理的存在，也就是类似GamePlayerProxy的存在，然后 才能访问。
 * 	   强制代理：调用者直接调用真实角色，而不用关心代理是否存在，其代理的产生是由真实角色
 * 				 决定的	
 * @author Administrator
 *
 */
public class Client {

	/*public static void main(String[] args){
		IGamePlayer gamePlayer = new GamePlayer("张三");
		
		IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
		
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		proxy.login("张三", "");
		
		proxy.killBoss();
		
		proxy.upgrade();
		
	}*/
	
	
	public static void main(String[] args){
//		IGamePlayer gamePlayer = new GamePlayer("张三");
		
//		IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
		IGamePlayer proxy = new GamePlayerProxy("张三");
		System.out.println("开始时间是: " + System.currentTimeMillis());
		
		proxy.login("张三", "");
		
		proxy.killBoss();
		
		proxy.upgrade();
		
	}
}
