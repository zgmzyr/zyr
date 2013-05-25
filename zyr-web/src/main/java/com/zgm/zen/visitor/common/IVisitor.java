package com.zgm.zen.visitor.common;

//抽象访问者
public interface IVisitor {

	public void visit(ConcreteElement1 concreteElement);
	
	public void visit(ConcreteElement2 concreteElement);
}
