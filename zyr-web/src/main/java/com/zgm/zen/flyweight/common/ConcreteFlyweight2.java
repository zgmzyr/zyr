package com.zgm.zen.flyweight.common;

public class ConcreteFlyweight2 extends Flyweight {

	
	public ConcreteFlyweight2(String extrinsic) {
		super(extrinsic);
	}

	@Override
	public void operate() {
		
		System.out.println("业务逻辑2");
		
	}

}
