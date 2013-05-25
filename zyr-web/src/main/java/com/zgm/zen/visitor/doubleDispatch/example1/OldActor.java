package com.zgm.zen.visitor.doubleDispatch.example1;

public class OldActor extends AbsActor {

	//覆写 (Override)
	public void act(KungFuRole role){
		System.out.println("年龄大了，不能演功夫角色");
	}
}
