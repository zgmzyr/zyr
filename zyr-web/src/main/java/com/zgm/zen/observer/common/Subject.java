package com.zgm.zen.observer.common;

import java.util.Vector;

/**
 * 被 观察者
 * @author Administrator
 *
 */
public abstract class Subject {

	//定义一个观察者数组
	private Vector<Observer> obsVector = new Vector<Observer>();
	
	public void addObserver(Observer o){
		this.obsVector.add(o);
	}
	
	public void delOberver(Observer o){
		this.obsVector.remove(o);
	}
	
	public void notifyObservers(){
		for(Observer o : this.obsVector){
			o.update();
		}
	}
}
