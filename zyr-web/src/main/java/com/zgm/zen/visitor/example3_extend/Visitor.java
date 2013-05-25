package com.zgm.zen.visitor.example3_extend;


public class Visitor implements IVisitor {

	private final static int MANAGER_COEFFICIENT = 5;
	
	private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
	
	private int commonTotalSalary = 0;
	private int managerTotalSalary = 0;
	
	private void calManagerSalary(int salary){
		this.managerTotalSalary = this.managerTotalSalary + salary * this.MANAGER_COEFFICIENT;
	}
	
	private void calCommonSalary(int salary){
		this.commonTotalSalary = this.commonTotalSalary + salary * this.COMMONEMPLOYEE_COEFFICIENT;
	}
	
	public int getTotalSalary(){
		return this.commonTotalSalary + this.managerTotalSalary;
	}
	
	@Override
	public void visit(CommonEmployee commonEmployee) {
		this.calCommonSalary(commonEmployee.getSalary());

//		System.out.println(this.getCommonEmployee(commonEmployee));
	}

	@Override
	public void visit(Manager manager) {

		this.calManagerSalary(manager.getSalary());
//		System.out.println(this.getManagerInfo(manager));
	}
	
	
	
	private String getBasicInfo(Employee employee){
		String info = "姓名：" + employee.getName() + "\t";
		info = info + "性别：" + (employee.getSex() == Employee.FEMALE ? "女" : "男") + "\t";
		info = info + "薪水：" + employee.getSalary() + "\t";
		
		return info;
	}
	
	private String getManagerInfo(Manager manager){
		String basicInfo = this.getBasicInfo(manager);
		String otherInfo = "业绩：" + manager.getPerformance()+ "\t";
		
		return basicInfo + otherInfo;
	}
	
	private String getCommonEmployee(CommonEmployee commonEmployee){
		String basicInfo = this.getBasicInfo(commonEmployee);
		String otherInfo = "工作： " + commonEmployee.getJob() + "\t";
			
		return basicInfo + otherInfo;	
	}

}

/*public class Visitor implements IVisitor {

	@Override
	public void visit(CommonEmployee commonEmployee) {

		System.out.println(this.getCommonEmployee(commonEmployee));
	}

	@Override
	public void visit(Manager manager) {

		System.out.println(this.getManagerInfo(manager));
	}
	
	
	
	private String getBasicInfo(Employee employee){
		String info = "姓名：" + employee.getName() + "\t";
		info = info + "性别：" + (employee.getSex() == Employee.FEMALE ? "女" : "男") + "\t";
		info = info + "薪水：" + employee.getSalary() + "\t";
		
		return info;
	}
	
	private String getManagerInfo(Manager manager){
		String basicInfo = this.getBasicInfo(manager);
		String otherInfo = "业绩：" + manager.getPerformance()+ "\t";
		
		return basicInfo + otherInfo;
	}
	
	private String getCommonEmployee(CommonEmployee commonEmployee){
		String basicInfo = this.getBasicInfo(commonEmployee);
		String otherInfo = "工作： " + commonEmployee.getJob() + "\t";
			
		return basicInfo + otherInfo;	
	}

}*/
