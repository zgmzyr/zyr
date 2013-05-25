package com.zgm.zen.visitor.example2;

public abstract class Employee {

	public final static int MALE = 0; //0代表男性
	public final static int FEMALE = 1;
	
	private String name;
	private int salary;
	private int sex;
	
	/*public final void report(){
		String info = "姓名：" + this.name + "\t";
		info = info + "性别：" + this.sex + "\t";
		info = info + "薪水：" + this.salary + "\t";
		info = info + this.getOtherInfo();
		
		System.out.println(info);
	}
	
	protected abstract String getOtherInfo();*/
	
	//我允许一个访问者访问
	public abstract void accept(IVisitor visitor);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
}

/*public abstract class Employee {

	public final static int MALE = 0; //0代表男性
	public final static int FEMALE = 1;
	
	private String name;
	private int salary;
	private int sex;
	
	public final void report(){
		String info = "姓名：" + this.name + "\t";
		info = info + "性别：" + this.sex + "\t";
		info = info + "薪水：" + this.salary + "\t";
		info = info + this.getOtherInfo();
		
		System.out.println(info);
	}
	
	protected abstract String getOtherInfo();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
}*/
