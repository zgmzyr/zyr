package com.zgm.zen.proxy.example;

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

}
