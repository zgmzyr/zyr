package com.zgm.zen.memento.common3;

public class Client {
	
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		
//		Caretaker caretaker = new Caretaker();
		
//		caretaker.setMemento(originator.createMemento());
//		caretaker.setOriginator(originator);
		originator.setState("初始状态。。。。");
		System.out.println("初始状态: " + originator.getState());
		
		originator.createMemento();
		
		originator.setState("修改后的状态。。。。。。");
		System.out.println("修改后的状态: " + originator.getState());
//		originator.restoreMemento(caretaker.getMemento());
//		originator.restoreMemento(caretaker.getOriginator());
		originator.restoreMemento();
		
		System.out.println("恢复后的状态是： " + originator.getState());
	}

	/*public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
//		caretaker.setMemento(originator.createMemento());
		caretaker.setOriginator(originator);
		
//		originator.restoreMemento(caretaker.getMemento());
		originator.restoreMemento(caretaker.getOriginator());
	}*/
	
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
		caretaker.setMemento(originator.createMemento());
		
		originator.restoreMemento(caretaker.getMemento());
	}*/

}
