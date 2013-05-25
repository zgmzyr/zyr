package com.zgm.zen.iterator.example;

import java.util.ArrayList;

import com.zgm.zen.iterator.example.IProject;


public class Project implements IProject {

	
	private String name = "";
	private int num = 0;
	private int cost = 0;
	
	public Project(){
		
	}
	
	public Project(String name, int num, int cost){
		this.name = name;
		this.num = num;
		this.cost = cost;
	}
	
	@Override
	public String getProjectInfo() {
		String info = "";
		
		info = info + "项目名称是：" + this.name;
		info += "\t项目人数:" + this.num;
		info += "\t项目费用:" + this.cost;
		
		return info;
	}
	

}
/*public class Project implements IProuect {

	private String name = "";
	private int num = 0;
	private int cost = 0;
	
	
	public Project(String name, int num, int cost){
		this.name = name;
		this.num = num;
		this.cost = cost;
	}
	
	@Override
	public String getProjectInfo() {
		String info = "";
		
		info = info + "项目名称是：" + this.name;
		info += "\t项目人数:" + this.num;
		info += "\t项目费用:" + this.cost;
		
		return info;
	}

}*/
