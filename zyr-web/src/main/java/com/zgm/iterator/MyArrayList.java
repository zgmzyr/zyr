package com.zgm.iterator;

public class MyArrayList {
	Object[] objects = new Object[10];
	private int index = 0;
	
	public void add(Object obj){
		if(index == objects.length){
			Object[] newObjects = new Object[objects.length * 2];
			System.arraycopy(objects, 0, newObjects, 0, objects.length);
			
			objects = newObjects;
		}
		
		objects[index] = obj;
		
		index++;
	}
	
	public Object get(int index){
		if(index < objects.length){
			return objects[index];
		}
		
		return null;
	}
	
	public int size(){
		return index;
	}
}
