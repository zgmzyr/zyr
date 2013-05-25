package com.zgm.zen.strategy.common;

/**
 * 具体策略角色
 * @author Administrator
 *
 */
public class ConcreteStrategy1 implements IStrategy {

	@Override
	public void doSomething() {

		System.out.println("具体策略1的运算法则");
	}

}
