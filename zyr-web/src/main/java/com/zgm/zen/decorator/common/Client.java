package com.zgm.zen.decorator.common;

public class Client {

	public static void main(String[] args){
		
		Component component = new ConreteComponent();
		
		//第一次修饰
		component = new ConcreteDecorator1(component);
		
		//第二次修饰
		component = new ConcreteDecorator2(component);
		
		component.operate();
		
	}
}
