package com.zgm.zen.integration.establishPattern_thirty.factoryVSbuilder.factory;

public class Clinet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ISuperMan adultSuperMan = SuperManFactory.createSuperMan("adult");
		
		adultSuperMan.specialTalent();
	}

}
