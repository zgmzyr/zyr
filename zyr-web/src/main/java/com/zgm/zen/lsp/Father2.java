package com.zgm.zen.lsp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Father2 {
	
	public Collection doSomething(Map map){
		System.out.println("父类被执行！");
		
		return map.values();
		
	}
}
