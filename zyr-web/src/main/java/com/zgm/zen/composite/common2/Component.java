package com.zgm.zen.composite.common2;

import java.util.ArrayList;

/**
 * 抽象构件
 * @author Administrator
 *
 */
public abstract class Component {

	//个体和整体都具有的共享
	public void doSomething(){
		
		System.out.println("业务逻辑处理");
	}
	
	public abstract void add(Component component);
	
	public abstract void remove(Component component);
	
	
	public abstract ArrayList<Component> getChildren();
		
}
