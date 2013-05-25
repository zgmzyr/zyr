package com.zgm.zen.lsp;

import java.util.HashMap;

public class Client2 {

	public static void invoker(){
		Father2 father = new Father2();
		HashMap map = new HashMap();
		
		father.doSomething(map);
		
		//
		
		Son2 son = new Son2();
		son.doSomething(map);
		
		Father2 son2 = new Son2();
		son2.doSomething(map);
	}
	
	public static void main(String[] args){
		invoker();
	}
}
