package com.zgm.zen.visitor.example4_extend;

public class ShowVisitor implements IShowVisitor {

	private String info = "";
	
	@Override
	public void visit(CommonEmployee commonEmployee) {
		this.info = this.info + this.getCommonEmployee(commonEmployee);
	}
	
	@Override
	public void visit(Manager manager) {

		
		this.info = this.info + this.getManagerInfo(manager);
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
	
	@Override
	public void report() {

		System.out.println(this.info);
		
	}

}
