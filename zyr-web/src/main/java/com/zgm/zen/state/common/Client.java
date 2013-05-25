package com.zgm.zen.state.common;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Context context = new Context();
		
		context.setCurrentState(new ConcreteState1());
		
//		context.handle1();
//		context.handle1();
		context.handle2();
		context.handle1();
	}

}
