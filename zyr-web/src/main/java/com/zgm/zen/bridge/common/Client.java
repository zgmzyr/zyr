package com.zgm.zen.bridge.common;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Implementor imp = new ConcreteImplementor1();
		
		Abstration abs = new RefinedAbstracting(imp);
		
		abs.request();
	}

}
