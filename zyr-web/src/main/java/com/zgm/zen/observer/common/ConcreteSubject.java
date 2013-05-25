package com.zgm.zen.observer.common;

/**
 * 具体被观察者
 * @author Administrator
 *
 */
public class ConcreteSubject extends Subject {

	//具体的业务
	public void doSomething(){
		//do someting
		
		super.notifyObservers();
	}
}
