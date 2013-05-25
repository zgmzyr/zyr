package com.zgm.zen.integration.establishPattern_thirty.factoryVSbuilder.builder;

public class ChildSuperManBuilder extends Builder {

	@Override
	public SuperMan getSuperMan() {
		
		super.setBody("强壮的身体");
		super.setSpecialTalent("刀枪不入");
		super.setSpecialSymbol("胸前带有小S标志");
		
		return super.superMan;
	}

}
