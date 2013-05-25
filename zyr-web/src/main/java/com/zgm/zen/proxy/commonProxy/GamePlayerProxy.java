package com.zgm.zen.proxy.commonProxy;

public class GamePlayerProxy implements IGamePlayer {
	private IGamePlayer gamePlayer = null;
	
	/*public GamePlayerProxy(IGamePlayer gamePlayer){
		this.gamePlayer = gamePlayer;
	}*/
	
	public GamePlayerProxy(String name){
		try{
			gamePlayer = new GamePlayer(name);
		}catch(Exception e){
			e.printStackTrace();
			//异常处理
		}
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
