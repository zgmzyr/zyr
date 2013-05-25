package com.zgm.zen.memento.example1;

public class Client {

	
	public static void main(String[] args){
		Boy boy = new Boy();
		
		boy.setState("心情很棒！");
		System.out.println("==========男孩现在的状态状态=======");
		System.out.println(boy.getState());
		
		Boy backup = new Boy();
		backup.setState(boy.getState());
		
		boy.changeState();
		System.out.println("\n=======男孩追女孩子后的状态状态=====");
		System.out.println(boy.getState());
		
		boy.setState(backup.getState());
		System.out.println("\n===========男孩恢复后的状态=====");
		System.out.println(boy.getState());
	}
}
