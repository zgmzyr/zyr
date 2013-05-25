package com.zgm.zen.adapter.commom;

/**
 * 适配器角色
 * @author Administrator
 *
 */
public class Adapter extends Adaptee implements Target{

	public void request(){
		super.doSomething();
	}
}
