package com.zgm.zen.proxy.forceProxy;

public class GamePlayer implements IGamePlayer {
	private IGamePlayer proxy = null;
	
	private String name = "";
	
	public GamePlayer(String name){
		this.name = name;
	}
	
	//找到自己的代理
	public IGamePlayer getProxy(){
		this.proxy = new GamePlayerProxy(this);//将this传递进去
		return proxy;
	}
	@Override
	public void killBoss() {
		if(this.isProxy()){
			System.out.println(this.name + "在打怪！");
		}else{
			System.out.println("请使用指定的代理访问");
		}
		
	}

	@Override
	public void login(String name, String password) {
		
		if(this.isProxy()){
			System.out.println("登录名为 " + name + "的用户登录成功！");
		}else{
			System.out.println("请使用指定的代理访问");
		}
	}

	@Override
	public void upgrade() {
		if(this.isProxy()){
			System.out.println(this.name + "又升了一级！");
		}else{
			System.out.println("请使用指定的代理访问");
		}
		
	}
	
	//检验是否是代理访问
	private boolean isProxy(){
		if(this.proxy == null){
			return false;
		}else{
			return true;
		}
	}

}
