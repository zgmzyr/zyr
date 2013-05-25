package com.zgm.zen.proxy.forceProxy;

public class GamePlayerProxy implements IGamePlayer {
	private IGamePlayer gamePlayer = null;
	
	public GamePlayerProxy(IGamePlayer gamePlayer){
		this.gamePlayer = gamePlayer;
	}
	
	@Override
	public void killBoss() {
		this.gamePlayer.killBoss();
	}

	@Override
	public void login(String name, String password) {
		this.gamePlayer.login(name, password);
	}

	@Override
	public void upgrade() {
		this.gamePlayer.upgrade();
	}
	
	//代理的代理暂时还没有，就是自己
	//代理角色也可以再次被代理
	public IGamePlayer getProxy(){
		return this;
	}

}
