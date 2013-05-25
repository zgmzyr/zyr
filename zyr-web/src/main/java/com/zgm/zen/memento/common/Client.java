package com.zgm.zen.memento.common;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		
		Caretaker caretaker = new Caretaker();
		
		caretaker.setMemento(originator.createMemento());
		
		originator.restoreMemento(caretaker.getMemento());
	}

}
