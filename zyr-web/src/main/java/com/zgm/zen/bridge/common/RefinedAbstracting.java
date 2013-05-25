package com.zgm.zen.bridge.common;

/**
 * 具体抽象化角色
 * @author Administrator
 *
 */
public class RefinedAbstracting extends Abstration {

	public RefinedAbstracting(Implementor imp) {
		super(imp);
	}


	//修正父类的行为
	public void request(){
		System.out.println("业务处理");
		
		super.request();
		
		super.getImp().doAnything();
	}
}
