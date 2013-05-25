package com.zgm.zen.visitor.example3_extend;


public interface IVisitor {

	public void visit(CommonEmployee commonEmployee);
	public void visit(Manager manager);
	
	public int getTotalSalary();
}

/*public interface IVisitor {

	public void visit(CommonEmployee commonEmployee);
	public void visit(Manager manager);
}*/
