package com.zgm.zen.visitor.example2;

public interface IVisitor {

	public void visit(CommonEmployee commonEmployee);
	public void visit(Manager manager);
}
