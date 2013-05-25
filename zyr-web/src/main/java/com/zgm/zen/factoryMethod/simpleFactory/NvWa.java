package com.zgm.zen.factoryMethod.simpleFactory;

public class NvWa {

	public static void main(String[] args){
		/*AbstractHumanFactory yinYangLu = new HumanFactory();
		
		Human blackHuman =  yinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
		
		Human yellowHuman = yinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();*/
		
		Human blackHuman = HumanFactory.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
		
		Human yellowHuman = HumanFactory.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
		
		
	}
}
