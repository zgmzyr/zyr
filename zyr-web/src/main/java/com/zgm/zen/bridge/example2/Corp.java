package com.zgm.zen.bridge.example2;

public abstract class Corp {

	
	protected abstract void produce();
	protected abstract void sell();
	
	public void makeMoney(){
		this.produce();
		this.sell();
	}
}
