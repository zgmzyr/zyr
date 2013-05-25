package com.zgm.zen.command.example1;

public class Client2 {

	public static void main(String[] args){
		
		System.out.println("--------客户要求删除一个页面--------");
		
		Group group = new PageGroup();
		
		group.find();
		group.delete();
		group.plan();
		
	}
}
