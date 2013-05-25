package com.zgm.zen.visitor.doubleDispatch.example1;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbsActor actor = new OldActor();
		
		Role role = new KungFuRole();
		
		actor.act(role);
		
		actor.act(new KungFuRole());
	}

}
