package com.zgm.zen.memento.common2;

public class Client {

	public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
//		caretaker.setMemento(originator.createMemento());
		caretaker.setOriginator(originator);
		
//		originator.restoreMemento(caretaker.getMemento());
		originator.restoreMemento(caretaker.getOriginator());
	}
	
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
