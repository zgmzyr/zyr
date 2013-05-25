package com.zgm.zen.state.common;

/**
 * 具体环境角色
 * @author Administrator
 *
 */
public class Context {

	//定义状态
	public static final State STATE1 = new ConcreteState1();
	public static final State STATE2 = new ConcreteState2();
	
	//当前状态
	private State currentState;
	
	public State getCurrentState(){
		return this.currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
		
		//切换状态
		this.currentState.setContext(this);
	}
	
	//行为委托
	public void handle1(){
		this.currentState.handle1();
	}
	
	public void handle2(){
		this.currentState.handle2();
	}
	
	
}
