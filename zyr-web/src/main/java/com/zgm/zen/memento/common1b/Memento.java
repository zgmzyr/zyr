package com.zgm.zen.memento.common1b;

import java.util.HashMap;

public class Memento {

	private HashMap<String, Object> stateMap;

	public Memento(HashMap<String, Object> map){
		this.stateMap = map;
	}
	
	public HashMap<String, Object> getStateMap() {
		return stateMap;
	}

	public void setStateMap(HashMap<String, Object> stateMap) {
		this.stateMap = stateMap;
	}

	
	
	/*private String state = "";
	
	public Memento(String state){
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}*/
	
	
		
}
