package com.zgm.zen.iterator.common;

public interface Aggregate {

	public void add(Object objet);
	
	public void remove(Object objet);
	
	public Iterator iterator();
}
