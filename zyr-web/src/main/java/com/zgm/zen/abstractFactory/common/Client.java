package com.zgm.zen.abstractFactory.common;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbstractCreator creator1 = new Creator1();
		AbstractCreator creator2 = new Creator2();
		
		AbstractProductA a1 =  creator1.createProductA();
		AbstractProductB b1 = creator1.createProductB();
		
		AbstractProductA a2 = creator2.createProductA();
		AbstractProductB b2 = creator2.createProductB();
	}

}
