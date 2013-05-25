package com.zgm.zen.state.common;

/***
 * 环境角色
 * @author Administrator
 *
 */
public class ConcreteState2 extends State {

	@Override
	public void handle1() {
		//设置当前状态为state1
		super.context.setCurrentState(Context.STATE1);
		
		//过渡到state1状态，由Context实现
		super.context.handle1();
		
	}

	@Override
	public void handle2() {
		
		System.out.println("本状态下必须处理逻辑---2");
	}

}
