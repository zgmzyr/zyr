package com.zgm.zen.facade.common2;

/**
 * 门面对象
 * 注：门面模式最大的缺点是：不符合开闭原则
 * 注：一个子系统可以有多个门面
 * @author Administrator
 *
 */
public class Facade2 {

	
	//被委托的对象
	private Facade facade = new Facade();
	
	//对外提供唯一的访问子系统的方法
	public void methodB(){
		this.facade.methodB();
	}
	
}
