package com.zgm.zen.visitor.doubleDispatch.example2;

public class KungFuRole implements Role{

	@Override
	public void accept(AbsActor actor) {
		
		actor.act(this);
	}

	
}
