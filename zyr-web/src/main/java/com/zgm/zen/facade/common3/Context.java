package com.zgm.zen.facade.common3;

/**
 * 封装类
 * @author Administrator
 *
 */
public class Context {

	private ClassA a = new ClassA();
	private ClassC c = new ClassC();
	
	//复杂的计算
	public void complexMethod(){
		this.a.doSomethingA();
		this.c.doSomethingC();
	}
}
