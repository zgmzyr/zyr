package com.zgm.zen.templateMethod;

public class ConcreteClass1 extends AbstractClass{

	@Override
	protected void doAnything() {
		System.out.println("ConcreteClass1 doAnything");
		
	}

	@Override
	protected void doSomething() {
		System.out.println("ConcreteClass1 doSomething");
	}
	

}
