package com.zgm.zen.observer.common;

public class ConcreteObserver implements Observer {

	@Override
	public void update() {

		System.out.println("接收到消息，进行处理！");
	}

}
