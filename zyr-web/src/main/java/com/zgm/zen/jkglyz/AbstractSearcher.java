package com.zgm.zen.jkglyz;

public abstract class AbstractSearcher {

	protected IGreatTemperamentGirl greatTemperamentGirl; 
	protected IGoodBodyGirl goodBodyGirl; 
	
	public AbstractSearcher(IGoodBodyGirl goodBodyGirl){
		this.goodBodyGirl = goodBodyGirl;
	}
	
	public AbstractSearcher(IGreatTemperamentGirl greatTemperamentGirl){
		this.greatTemperamentGirl = greatTemperamentGirl;
	}
	
	abstract void show();
	
}
