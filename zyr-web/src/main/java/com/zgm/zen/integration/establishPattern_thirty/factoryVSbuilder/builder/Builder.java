package com.zgm.zen.integration.establishPattern_thirty.factoryVSbuilder.builder;

public abstract class Builder {

	protected final SuperMan superMan = new SuperMan();
	
	public void setBody(String body){
		this.superMan.setBody(body);
	}
	
	public void setSpecialSymbol(String specialSymbol) {
		this.superMan.setSpecialSymbol(specialSymbol);
	}
	
	public void setSpecialTalent(String specialTalent) {
		this.superMan.setSpecialTalent(specialTalent);
		
	}
	
	public abstract SuperMan getSuperMan();
}
