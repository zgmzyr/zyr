package com.zgm.zen.memento.common1c;

import java.util.HashMap;

public class Caretaker {
	
	//实际项目中，应该为memMap设置上限，防止内存溢出
	private HashMap<String, Memento> memMap = new HashMap<String, Memento>();
	
	public Memento getMemento(String idx){
		return memMap.get(idx);
	}
	
	public void setMemento(String idx, Memento memento){
		memMap.put(idx, memento);
	}

	/*private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}*/
	
	
}
/*public class Caretaker {

	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
}*/
