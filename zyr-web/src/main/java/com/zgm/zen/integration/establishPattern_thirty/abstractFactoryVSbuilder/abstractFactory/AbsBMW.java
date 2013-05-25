package com.zgm.zen.integration.establishPattern_thirty.abstractFactoryVSbuilder.abstractFactory;

public abstract class AbsBMW implements ICar {

	private final static String BMW_BAND = "宝马汽车";
	
	@Override
	public String getBrand() {
		
		
		return BMW_BAND;
	}

	public abstract String getModel();

}
