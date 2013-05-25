package com.zgm.zen.composite.example3;

import java.util.ArrayList;

//public class Branch implements IBranch {
public class Branch extends Corp {

//	private ArrayList<ICorp> subordinateList = new ArrayList<ICorp>();
	private ArrayList<Corp> subordinateList = new ArrayList<Corp>();
	/*private String name = "";
	private String position = "";
	
	private int salary = 0;*/

	public Branch(String name, String position,
			int salary) {
		super(name, position, salary );
		/*this.name = name;
		this.position = position;
		this.salary = salary;*/
	}
	
	public void addSubordinate(Corp corp){
		this.subordinateList.add(corp);
	}
	
	public ArrayList<Corp> getSubordinate(){
		return this.subordinateList;
	}
	
	/*public void delSubordinate(ICorp corp){
		this.subordinateList.remove(corp);
	}
*/
	/*@Override
	public String getInfo() {
		String info = "";
		
		info = "名称：" + this.name;
		info = info + "\t职位：" + this.position;
		info = info + "\t薪水：" + this.salary;
		
		
		return info;
	}*/


	
}

/*public class Branch implements IBranch {

//	private ArrayList subordinateList = new ArrayList();
	private ArrayList<ICorp> subordinateList = new ArrayList<ICorp>();
	private String name = "";
	private String position = "";
	
	private int salary = 0;
	
	public Branch(String name, String position,
			int salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	public void addSubordinate(ICorp corp){
		this.subordinateList.add(corp);
	}
	
	public ArrayList<ICorp> getSubordinate(){
		return this.subordinateList;
	}
	
	public void delSubordinate(ICorp corp){
		this.subordinateList.remove(corp);
	}

	@Override
	public String getInfo() {
		String info = "";
		
		info = "名称：" + this.name;
		info = info + "\t职位：" + this.position;
		info = info + "\t薪水：" + this.salary;
		
		
		return info;
	}


	
}*/
