package com.zgm.zen.factoryMethod.common;

/**
 * 抽象工厂类
 * @author Administrator
 *
 */
public abstract class Creator {

	/**
	 * 创建一个产品对象，其输入参数类形为Class,String,Enum等，
	 * 当然也可以为空，并不局限于为Class类型
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public abstract <T extends Product> T createProduct(Class<T> clazz);
}
