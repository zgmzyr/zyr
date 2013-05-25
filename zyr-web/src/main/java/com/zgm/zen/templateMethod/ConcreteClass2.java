package com.zgm.zen.templateMethod;

public class ConcreteClass2 extends AbstractClass{

	@Override
	protected void doAnything() {
		System.out.println("ConcreteClass2 doAnything");
		
	}

	@Override
	protected void doSomething() {
		System.out.println("ConcreteClass2 doSomething");
	}
	

}
