package com.zgm.zen.factoryMethod.singletonFactory;

public class Client {

	public static void main(String[] args){
		Singleton singleton = SingletonFactory.getSingleton();
		
		singleton.doSomething();
	}
}
