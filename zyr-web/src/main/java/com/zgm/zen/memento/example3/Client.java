package com.zgm.zen.memento.example3;

public class Client {

	
	public static void main(String[] args){
		Boy boy = new Boy();
		
		Caretaker caretaker = new Caretaker();
		
		boy.setState("心情很棒！");
		System.out.println("==========男孩现在的状态状态=======");
		System.out.println(boy.getState());
		
//		Boy backup = new Boy();
//		backup.setState(boy.getState());
//		Memento memento = boy.createMemento();
		caretaker.setMemento(boy.createMemento());
		
		boy.changeState();
		System.out.println("\n=======男孩追女孩子后的状态状态=====");
		System.out.println(boy.getState());
		
//		boy.setState(backup.getState());
//		boy.restoreMemento(memento);
		boy.restoreMemento(caretaker.getMemento());
		System.out.println("\n===========男孩恢复后的状态=====");
		System.out.println(boy.getState());
	}
	
	/*public static void main(String[] args){
		Boy boy = new Boy();
		
		boy.setState("心情很棒！");
		System.out.println("==========男孩现在的状态状态=======");
		System.out.println(boy.getState());
		
//		Boy backup = new Boy();
//		backup.setState(boy.getState());
		Memento memento = boy.createMemento();
		
		boy.changeState();
		System.out.println("\n=======男孩追女孩子后的状态状态=====");
		System.out.println(boy.getState());
		
//		boy.setState(backup.getState());
		boy.restoreMemento(memento);
		System.out.println("\n===========男孩恢复后的状态=====");
		System.out.println(boy.getState());
	}*/
	
	/*public static void main(String[] args){
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
	}*/
}
