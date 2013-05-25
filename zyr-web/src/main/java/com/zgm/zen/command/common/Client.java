package com.zgm.zen.command.common;

public class Client {

	public static void main(String[] args){
		
		Invoker invoker = new Invoker();
		Receiver receive = new ConcreteReceiver1();
		Command command = new ConcreteCommand1(receive);
		invoker.setCommand(command);
		
		invoker.action();
		
		
	}
}
