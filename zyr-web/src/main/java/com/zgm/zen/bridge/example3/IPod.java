package com.zgm.zen.bridge.example3;

public class IPod extends Product {

	@Override
	public void beProducted() {

		System.out.println("生产IPod..");
	}

	@Override
	public void beSell() {

		System.out.println("IPod热卖中..");
	}

}
