package com.zgm.zen.mediator.common;

/**
 * 具体同事类
 * @author Administrator
 *
 */
public class ConcreteColleague2 extends Colleague {

	/**
	 * 通过构造者传递中介者
	 * @param mediator
	 */
	public ConcreteColleague2(Mediator mediator){
		super(mediator);
	}
	
	//自有方法 self-method
	public void selfMethod(){
		System.out.println("处理自己的业务逻辑");
	}
	
	public void dependMethod2(){
		//处理自己的业务逻辑
		
		//自己不能处理的业务逻辑，委托给中介者处理
		super.mediator.doSomething2();
		
	}
}
