package com.zgm.fastjson.serializer.PropertyFilter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class ComplexPropertyPreFilterTest {
	
	@Test
	public void test() {
		Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();  
        Set<String> set = new HashSet<String>();  
        set.add("name");  
        includeMap.put(Sub.class, set);  
          
        ComplexPropertyPreFilter cfilter = new ComplexPropertyPreFilter(includeMap);  
//        SerializeWriter sw = new SerializeWriter();  
//        JSONSerializer serializer = new JSONSerializer(sw);   
//        serializer.getPropertyFilters().add(cfilter);  
        
        Sub sub = new Sub();
        sub.setAge(20);
        sub.setName("zyr");
        Container container = new Container();
        container.setSub(sub);
        container.setI(30);
//        serializer.write(sub);    
        
        System.out.println(JSON.toJSONString(container, cfilter));
	}

}

class Container implements Serializable {
	private static final long serialVersionUID = 5904272868313304202L;
	
	private int i = 1;

	public int getI() {
		return i;
	}

	public Sub getSub() {
		return sub;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setSub(Sub sub) {
		this.sub = sub;
	}

	private Sub sub;
}

class Sub implements Serializable {
	private static final long serialVersionUID = 6188012490450991968L;
	
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
