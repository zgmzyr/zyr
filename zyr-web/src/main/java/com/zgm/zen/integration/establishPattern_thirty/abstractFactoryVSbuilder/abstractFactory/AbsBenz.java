package com.zgm.zen.integration.establishPattern_thirty.abstractFactoryVSbuilder.abstractFactory;

public abstract class AbsBenz implements ICar {

	private final static String BENZ_BAND = "奔驰汽车";
	
	@Override
	public String getBrand() {
		return AbsBenz.BENZ_BAND;
	}

	public abstract String getModel();

}
