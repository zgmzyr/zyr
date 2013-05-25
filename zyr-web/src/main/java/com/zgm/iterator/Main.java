package com.zgm.iterator;

public class Main {
	
	public static void main(String[] strs){
		MyArrayList list = new MyArrayList();
		for(int i = 0; i < 20; i++){
			list.add("你好： " + i);
		}
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println(list.size());
		
		MyLinkedList linkedList = new MyLinkedList();
		for(int i = 0; i < 20; i++){
			linkedList.add("你好： " + i);
		}
		System.out.println(linkedList.size());
	}
}
