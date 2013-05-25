package com.zgm.zen.adapter.commom;

/**
 * 目标角色实现类
 * @author Administrator
 *
 */
public class ConcreteTarget implements Target {

	@Override
	public void request() {

		System.out.println("如果你需要帮助，请告诉我！");
	}

}
