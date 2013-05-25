package com.zgm.zen.memento.common3;

import com.zgm.zen.memento.common3.Originator;

/**
 * 发起人自主备份和恢复
 * @author Administrator
 *
 */
public class Originator implements Cloneable{

	
private String state = "";
	
	private Originator backup;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	/*public Originator createMemento(){
		return this.clone();
	}*/
	
	public void createMemento(){
		this.backup = this.clone();
	}
	
	
	/*public void restoreMemento(Originator originator){
		this.setState(originator.getState());
	}*/
	
	public void restoreMemento(){
		this.setState(this.backup.getState());
	}

	@Override
	protected Originator clone() {

		try{
			return (Originator) super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/*public Memento createMemento(){
		return new Memento(this.state);
	}
	
	public void restoreMemento(Memento memento){
		this.setState(memento.getState());
	}*/
	
}
/*public class Originator {

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
	
	public void restoreMemento(Memento memento){
		this.setState(memento.getState());
	}
	
}*/
