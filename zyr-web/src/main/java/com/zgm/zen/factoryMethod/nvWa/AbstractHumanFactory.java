package com.zgm.zen.factoryMethod.nvWa;

public abstract class AbstractHumanFactory {

	public abstract <T extends Human> T createHuman(Class<T> clazz);
}
