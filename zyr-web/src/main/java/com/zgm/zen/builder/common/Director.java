package com.zgm.zen.builder.common;

public class Director {

	private Builder builder = new ConcreteProduct();
	
	//构建不同的产品
	public Product getAProduct(){
		builder.setPart();
		
		return builder.buildProduct();
	}
	
	public Product getBProduct(){
		builder.setPart();
		
		return builder.buildProduct();
	}
	
}
