package com.zgm.zen.integration.establishPattern_thirty.factoryVSbuilder.builder;

public class Client {

	public static void main(String[] args){
		SuperMan adultSuperMan = Director.getAdultSuperMan();
		
		adultSuperMan.getSpecialTalent();
	}
}
