package com.zgm.zen.builder.common;

public class ConcreteProduct extends Builder {

	private Product product = new Product();
	
	//组建一个产品
	@Override
	public Product buildProduct() {
		return product;
	}

	/**
	 * 设置产品零件
	 */
	@Override
	public void setPart() {
		
		System.out.println("设置产品零件");
	}

}
