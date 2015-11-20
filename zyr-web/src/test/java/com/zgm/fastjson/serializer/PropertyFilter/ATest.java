package com.zgm.fastjson.serializer.PropertyFilter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

class Wheel{
	String name;
	int size;
	String color;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Wheel() {
		super();
		this.color="black";
		this.name="miqilin";
		this.size = 17;
	}
	
	
}
class Sofa{
	String color;
	int count;
	String texture;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	public Sofa() {
		super();
		this.color = "white";
		this.count = 4;
		this.texture = "fur";
	}
	
	
}
class Car {
	private Wheel wheel;
	private Sofa sofa;
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	public Sofa getSofa() {
		return sofa;
	}
	public void setSofa(Sofa sofa) {
		this.sofa = sofa;
	}
	public Car() {
		super();
		this.wheel = new Wheel();
		this.sofa = new Sofa();
	}
	
	
}
public class ATest {

	public static void main(String args[]){
		Map<String,Car> map = new HashMap<String, Car>();
		map.put("car1", new Car());
		map.put("car2", new Car());
		//需要过滤的类 + 属性
		Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();
		Set<String> set = new HashSet<String>();
		set.add("color");
		includeMap.put(Wheel.class, set);
		set = new HashSet<String>();
		set.add("texture");
		includeMap.put(Sofa.class, set);
		
		
		ComplexPropertyPreFilter cfilter = new ComplexPropertyPreFilter(includeMap);
		SerializeWriter sw = new SerializeWriter();
		JSONSerializer serializer = new JSONSerializer(sw); 
		serializer.getPropertyFilters().add(cfilter);
		serializer.write(map);  
		
		System.out.println(sw.toString());
	}

}

