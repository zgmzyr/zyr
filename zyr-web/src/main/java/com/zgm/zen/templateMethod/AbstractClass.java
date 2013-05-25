package com.zgm.zen.templateMethod;

public abstract class AbstractClass {

	//基本方法
	protected abstract void doSomething();
	
	//基本方法
	protected abstract void doAnything();
	
	//模板方法
	public void templateMehod(){
		
		this.doSomething();
		this.doAnything();
	}
}
