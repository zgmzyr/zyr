package com.zgm.zen.bridge.common;

public class ConcreteImplementor2 implements Implementor {

	@Override
	public void doAnything() {
		System.out.println("业务逻辑处理somthing 2");

	}

	@Override
	public void doSomething() {
		System.out.println("业务逻辑处理Anything 2");
	}

}
