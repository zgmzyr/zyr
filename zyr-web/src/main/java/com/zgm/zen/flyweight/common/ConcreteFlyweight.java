package com.zgm.zen.flyweight.common;

public class ConcreteFlyweight extends Flyweight {

	
	public ConcreteFlyweight(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate() {
		
		System.out.println("业务逻辑1");
		
	}

}
