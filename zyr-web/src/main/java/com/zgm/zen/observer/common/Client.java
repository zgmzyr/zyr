package com.zgm.zen.observer.common;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConcreteSubject subject = new ConcreteSubject();
		
		Observer obs = new ConcreteObserver();
		
		subject.addObserver(obs);
		
		subject.doSomething();
		
	}

}
