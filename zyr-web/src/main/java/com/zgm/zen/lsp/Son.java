package com.zgm.zen.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Son extends Father {
	
	//子类的前置条件大
	public Collection doSomething(Map map){
		System.out.println("子类被执行！");
		
		return map.values();
		
	}
}
