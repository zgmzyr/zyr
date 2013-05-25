package com.zgm.zen.proxy.common;

/**
 * 真实主题类
 * @author Administrator
 *
 */
public class RealSubject implements Subject {

	@Override
	public void request() {
		
		System.out.println("业务逻辑处理！");
	}

}
