package com.zgm.zen.iterator.common;

import java.util.Vector;

public class ConcreteAggregate implements Aggregate {

	private Vector vector = new Vector();
	
	
	@Override
	public void add(Object object) {
		this.vector.add(object);
		
	}

	@Override
	public Iterator iterator() {
		return new ConcreteIterator(this.vector);
	}

	@Override
	public void remove(Object objet) {

		this.vector.remove(objet);
	}

}
