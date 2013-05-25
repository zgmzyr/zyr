package com.zgm.zen.integration.establishPattern_thirty.factoryVSbuilder.builder;

public class AdultSuperManBuilder extends Builder {

	@Override
	public SuperMan getSuperMan() {
		
		super.setBody("强壮的身体");
		super.setSpecialTalent("会飞行");
		super.setSpecialSymbol("胸前有S标志");
		
		return super.superMan;
	}

}
