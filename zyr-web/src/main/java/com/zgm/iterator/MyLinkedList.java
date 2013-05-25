package com.zgm.iterator;

public class MyLinkedList {
	private Node head = null;
	private Node tail = null;
	private int index = 0;
	
	public void add(Object obj){
		Node node = new Node();
		node.setData(obj);
		node.setNext(null);
		
		if(head == null){
			head = node;
			tail = node;
			index++;
			return;
		}
		
		tail.setNext(node);
		tail = node;
		index++;
		
	}
	
	/*public int get(int index){
		if(index < this.index){
			Node nodeTem = head;
			int indexTem = 0;
			if(nodeTem != null && index == indexTem){
				
			}

		}
	}*/
	
	public int size(){
		return index;
	}
}
