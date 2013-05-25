package com.zgm.zen.abstractFactory.nvNa;

public class MaleFactory implements HumanFactory {

	@Override
	public Human createBlackHuman() {
		return new MaleBlackHuman();
	}

	@Override
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}

}
