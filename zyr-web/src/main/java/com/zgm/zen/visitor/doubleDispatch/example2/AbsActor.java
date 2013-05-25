package com.zgm.zen.visitor.doubleDispatch.example2;

public abstract class AbsActor {

	
	public void act(Role role){
		System.out.println("演员可以扮演任何角色！");
	}
	
	//重载（overload）
	public void act(KungFuRole role){
		System.out.println("演员可以演工夫角色");
	}
}
