package com.zgm.zen.visitor.common;


//具体元素
public class ConcreteElement1 extends Element {

	@Override
	public void accept(IVisitor visitor) {

		visitor.visit(this);
	}

	@Override
	public void doSomething() {

		//业务处理
		System.out.println("业务处理1");
	}

}
