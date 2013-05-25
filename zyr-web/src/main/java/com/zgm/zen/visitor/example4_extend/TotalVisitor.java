package com.zgm.zen.visitor.example4_extend;

public class TotalVisitor implements ITotalVisitor {

private final static int MANAGER_COEFFICIENT = 5;
	
	private final static int COMMONEMPLOYEE_COEFFICIENT = 2;
	
	private int commonTotalSalary = 0;
	private int managerTotalSalary = 0;
	
	@Override
	public void totalSalary() {
		System.out.println("本公司的月工资总额是：" + (this.commonTotalSalary + this.managerTotalSalary));
	}

	@Override
	public void visit(CommonEmployee commonEmployee) {
		this.commonTotalSalary = this.commonTotalSalary + commonEmployee.getSalary() * this.COMMONEMPLOYEE_COEFFICIENT;
	}

	@Override
	public void visit(Manager manager) {
		this.managerTotalSalary = this.managerTotalSalary + manager.getSalary() * this.MANAGER_COEFFICIENT;
	}
	
	
	
	
	
	

}
