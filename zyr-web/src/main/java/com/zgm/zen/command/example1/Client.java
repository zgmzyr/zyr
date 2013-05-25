package com.zgm.zen.command.example1;

public class Client {

	public static void main(String[] args){
		
		System.out.println("--------客户要求增加一项需求--------");
		
		Group group = new RequirementGroup();
		
		group.find();
		group.add();
		group.plan();
		
	}
}
