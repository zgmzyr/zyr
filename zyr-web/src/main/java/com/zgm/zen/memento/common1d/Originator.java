package com.zgm.zen.memento.common1d;

public class Originator {

	private String state = "";

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Memento createMemento(){
		return new Memento(this.state);
	}
	
	public void restoreMemento(IMemento memento){
		this.setState(((Memento) memento).getState());
	}
	
	//内部类
	private class Memento implements IMemento{
		private String state = "";
		
		private Memento(String state){
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}
	
}
