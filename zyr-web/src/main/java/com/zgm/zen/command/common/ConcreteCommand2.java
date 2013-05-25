package com.zgm.zen.command.common;

public class ConcreteCommand2 extends Command {
	//
	private Receiver receive;
	
	public ConcreteCommand2(Receiver receive){
		this.receive = receive;
	}
	
	public void execute(){
		//业务处理
		receive.doSomething();
	}

}
