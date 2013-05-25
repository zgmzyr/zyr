package com.zgm.zen.mediator.example2;

public abstract class AbstractColleague {

	protected AbstractMediator mediator;
	
	public AbstractColleague(AbstractMediator mediator){
		this.mediator = mediator;
	}
}
