package com.zgm.zen.strategy.common;

/**
 * 封装角色
 * @author Administrator
 *
 */
public class Context {

	//抽象策略
	private IStrategy strategy = null;
	
	public Context(IStrategy strategy){
		this.strategy = strategy;
	}
	
	//封装后的策略方法
	public void doAnything(){
		this.strategy.doSomething();
	}
}
