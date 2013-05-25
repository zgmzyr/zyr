package com.zgm.zen.integration.establishPattern_thirty.abstractFactoryVSbuilder.abstractFactory;

public class BenzSuv extends AbsBenz {

	private final static String G_SERIES = "G系列SUV";
	
	@Override
	public String getModel() {
		return BenzSuv.G_SERIES;
	}

}
