package com.zgm.zen.iterator.common;

public class Client {

	public static void main(String[] args){
		
		Aggregate agg = new ConcreteAggregate();
		
		agg.add("abc");
		agg.add("aaa");
		agg.add("ddss");
		
		Iterator iterator = agg.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
