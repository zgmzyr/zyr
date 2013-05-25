package com.zgm.zen.observer.example3;

public interface Observable {

	public void addOberver(Observer observer);
	
	public void deleteObserver(Observer observer);
	
	public void notifyObservers(String context);
	
}
