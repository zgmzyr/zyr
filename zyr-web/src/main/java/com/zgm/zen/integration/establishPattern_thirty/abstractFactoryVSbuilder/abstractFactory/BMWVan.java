package com.zgm.zen.integration.establishPattern_thirty.abstractFactoryVSbuilder.abstractFactory;

public class BMWVan extends AbsBMW {

	private final static String SEVENT_SEARIES = "7系列型商务车";
	
	@Override
	public String getModel() {
		
		return BMWVan.SEVENT_SEARIES;
	}

}
