package com.zgm.zen.bridge.common;

/**
 * 抽象化角色
 * @author Administrator
 *
 */
public class Abstration {

	//定义对实现化角色的引用
	private Implementor imp;
	
	//约束子类必须实现该构造函数
	public Abstration(Implementor imp){
		this.imp = imp;
	}
	
	public void request(){
		this.imp.doSomething();
	}
	
	public Implementor getImp(){
		return this.imp;
	}
}
