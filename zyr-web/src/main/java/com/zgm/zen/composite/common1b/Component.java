package com.zgm.zen.composite.common1b;

/**
 * 抽象构件
 * @author Administrator
 *
 */
public abstract class Component {

	private Component parent = null;
	

	//个体和整体都具有的共享
	public void doSomething(){
		
		System.out.println("业务逻辑处理");
	}
	
	public Component getParent() {
		return parent;
	}

	protected void setParent(Component parent) {
		this.parent = parent;
	}
}
