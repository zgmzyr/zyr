package com.zgm.zen.iterator.example2;

import java.util.ArrayList;

import com.zgm.zen.iterator.example2.Project;


public class Project implements IProject {

	ArrayList<IProject> projectList = new ArrayList<IProject>();
	
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
	
	public void add(String name, int num, int cost){
		this.projectList.add(new Project(name, num, cost));
		
	}
	
	public IProjectIterator iterator(){
		return new ProjectIterator(this.projectList);
	}

}
