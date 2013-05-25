package com.zgm.zen.integration.establishPattern_thirty.abstractFactoryVSbuilder.abstractFactory;

public class BenzVan extends AbsBenz {

	private final static String R_SERIES = "R系列商务车";
	
	@Override
	public String getModel() {
		return BenzVan.R_SERIES;
	}

}
