package com.zgm.zen.mediator.common;

/**
 * 抽象同事类
 * @author Administrator
 *
 */
public abstract class Colleague {

	protected Mediator mediator;
	
	public Colleague(Mediator mediator){
		this.mediator = mediator;
	}
}
