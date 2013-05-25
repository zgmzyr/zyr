package com.zgm.zen.bridge.example3;

public class House extends Product {

	@Override
	public void beProducted() {
		System.out.println("生产出的IPod是这样的。。");
	}

	@Override
	public void beSell() {
		System.out.println("生产出的IPod卖出去了。。");
	}

}
