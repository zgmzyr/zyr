package com.zgm.zen.lsp;

import java.util.HashMap;

public class Client {

	public static void invoker(){
		Father father = new Father();
		HashMap map = new HashMap();
		
		father.doSomething(map);
		
		//
		
		Son son = new Son();
		son.doSomething(map);
	}
	
	public static void main(String[] args){
		invoker();
	}
}
