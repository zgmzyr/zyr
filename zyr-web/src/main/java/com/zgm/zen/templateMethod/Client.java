package com.zgm.zen.templateMethod;

public class Client {

	public static void main(String[] args){
		
		AbstractClass class1 = new ConcreteClass1();
		AbstractClass class2 = new ConcreteClass2();
		
		class1.templateMehod();
		class2.templateMehod();
	}
}
