package com.zgm.zen.abstractFactory.nvNa;

public class FemaleFactory implements HumanFactory {

	@Override
	public Human createBlackHuman() {
		return new FemaleBlackHuman();
	}

	@Override
	public Human createYellowHuman() {
		return new FemaleYellowHuman();
	}

}
