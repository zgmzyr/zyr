package com.zgm.zen.visitor.common;


public class ConcreteElement2 extends Element {

	@Override
	public void accept(IVisitor visitor) {

		visitor.visit(this);
	}

	@Override
	public void doSomething() {

		//业务处理
		System.out.println("业务处理2");
	}

}
