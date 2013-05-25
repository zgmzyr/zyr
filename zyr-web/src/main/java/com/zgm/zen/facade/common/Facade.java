package com.zgm.zen.facade.common;

/**
 * 门面对象
 * 注：门面模式最大的缺点是：不符合开闭原则
 * @author Administrator
 *
 */
public class Facade {

	
	//被委托的对象
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
	private ClassC c = new ClassC();
	
	//提供给外部访问的方法
	public void methodA(){
		a.doSomethingA();
	}
	
	public void methodB(){
		b.doSomethingB();
	}
	
	public void methodC(){
		c.doSomethingC();
	}
}
