package com.zgm.zen.visitor.example4_extend;

public interface ITotalVisitor extends IVisitor {

	//统计所有员工的工资总和
	public void totalSalary();
}
