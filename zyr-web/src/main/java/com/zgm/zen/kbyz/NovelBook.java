package com.zgm.zen.kbyz;

public class NovelBook implements IBook {
	
	private String name;
	private int price;
	
	public NovelBook(){}
	
	public NovelBook(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getPrice(){
		return this.price;
	}
}
