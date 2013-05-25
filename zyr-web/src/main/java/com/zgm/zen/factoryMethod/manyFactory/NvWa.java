package com.zgm.zen.factoryMethod.manyFactory;

public class NvWa {

	/*public static void main(String[] args){
		AbstractHumanFactory yinYangLu = new HumanFactory();
		
		Human blackHuman =  yinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
		
		Human yellowHuman = yinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
	}*/
	
	public static void main(String[] args){
		
		Human blackHuman = (new BlackHumanFactory()).createHuman();
		blackHuman.getColor();
		blackHuman.talk();
		
		Human yellowHuman = (new YellowHumanFactory()).createHuman();
		yellowHuman.getColor();
		yellowHuman.talk();
	}
}
