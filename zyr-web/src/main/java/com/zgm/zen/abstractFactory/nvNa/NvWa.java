package com.zgm.zen.abstractFactory.nvNa;

public class NvWa {

	public static void main(String[] args){
		HumanFactory maleHumanFactory = new MaleFactory();
		
		HumanFactory femaleHumanFactory = new FemaleFactory();
		
		Human maleYellowHuman = maleHumanFactory.createYellowHuman();
		Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
		
		maleYellowHuman.getSex();
		femaleYellowHuman.getSex();
	}
	
	
	
}
