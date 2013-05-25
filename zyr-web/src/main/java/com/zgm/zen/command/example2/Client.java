package com.zgm.zen.command.example2;

public class Client {

	/*public static void main(String[] args){
		
		System.out.println("--------客户要求增加一项需求--------");
		
		Group group = new RequirementGroup();
		
		group.find();
		group.add();
		group.plan();
		
	}*/
	
	public static void main(String[] args){
		
		System.out.println("--------客户要求增加一项需求--------");
		
//		Group group = new RequirementGroup();
		Invoker invoker = new Invoker();
		Command command = new AddRequirementCommand();
		invoker.setCommand(command);
		invoker.action();
		
		
		
	}
}
