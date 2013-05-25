package com.zgm.zen.command.example2;

public class Client2 {

	/*public static void main(String[] args){
		
		System.out.println("--------客户要求删除一个页面--------");
		
		Group group = new PageGroup();
		
		group.find();
		group.delete();
		group.plan();
		
	}*/
	
	public static void main(String[] args){
		
		System.out.println("--------客户要求删除一个页面--------");
		
//		Group group = new PageGroup();
		Invoker invoker = new Invoker();
		Command command = new DeletePageCommand();
		invoker.setCommand(command);
		invoker.action();
		
		
	}
}
