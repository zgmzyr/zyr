package com.zgm.zen.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Son2 extends Father2 {
	
	//子类的前置条件小
	public Collection doSomething(HashMap map){
		System.out.println("子类被执行！");
		
		return map.values();
		
	}
}
