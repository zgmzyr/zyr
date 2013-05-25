package com.zgm.zen.adapter.commom;

public class Client {

	public static void main(String[] args){
		//原有的业务逻辑
		Target target = new ConcreteTarget();
		target.request();
		
		//增加了适配器角色后业务逻辑
		Target target2 = new Adapter();
		target2.request();
	}
	
}
