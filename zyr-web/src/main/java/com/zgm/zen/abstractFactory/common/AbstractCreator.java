package com.zgm.zen.abstractFactory.common;

/**
 * 抽象工厂类
 * 注意：1.有N个产品族，在抽象工厂类中就有N个创建方法
 * 		 2.有M个产品等级就应该有M个实现工厂类，在每个实现工厂类中，实现不同产品族的生产任务	
 * @author Administrator
 *
 */
public abstract class AbstractCreator {

	//创建A产品族
	public abstract AbstractProductA createProductA();
	
	//创建B产品族
	public abstract AbstractProductB createProductB();
}
