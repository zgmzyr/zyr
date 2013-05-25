package com.zgm.zen.bridge.example3;

public class ShanZhaiCorp extends Corp {

	public ShanZhaiCorp(Product product) {
		super(product);
	}

	public void makeMoney(){
		super.makeMoney();
		System.out.println("我赚钱了。。。。");
	}
}
