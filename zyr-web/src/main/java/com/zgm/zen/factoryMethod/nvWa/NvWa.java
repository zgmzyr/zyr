package com.zgm.zen.factoryMethod.nvWa;

public class NvWa {

	public static void main(String[] args){
		AbstractHumanFactory yinYangLu = new HumanFactory();
		
		Human blackHuman =  yinYangLu.createHuman(BlackHuman.class);
		blackHuman.getColor();
		blackHuman.talk();
		
		Human yellowHuman = yinYangLu.createHuman(YellowHuman.class);
		yellowHuman.getColor();
		yellowHuman.talk();
	}
}
