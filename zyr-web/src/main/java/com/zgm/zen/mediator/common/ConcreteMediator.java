package com.zgm.zen.mediator.common;

/**
 * 通用中介者
 * @author Administrator
 *
 */
public class ConcreteMediator extends Mediator {

	private String name;
	
	@Override
	public void doSomething1() {

		super.concreteColleague1.selfMethod();
		super.concreteColleague2.selfMethod();
		
	}

	@Override
	public void doSomething2() {
		
		super.concreteColleague1.selfMethod();
		super.concreteColleague2.selfMethod();
	}

}
