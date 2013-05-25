package com.zgm.zen.bridge.common;

public class ConcreteImplementor1 implements Implementor {

	@Override
	public void doAnything() {
		System.out.println("业务逻辑处理somthing 1");

	}

	@Override
	public void doSomething() {
		System.out.println("业务逻辑处理Anything 1");
	}

}
