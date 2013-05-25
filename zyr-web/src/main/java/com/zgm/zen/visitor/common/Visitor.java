package com.zgm.zen.visitor.common;


/**
 * 具体访问者
 * @author Administrator
 *
 */
public class Visitor implements IVisitor {

	@Override
	public void visit(ConcreteElement1 concreteElement) {

		concreteElement.doSomething();
	}

	@Override
	public void visit(ConcreteElement2 concreteElement) {

		concreteElement.doSomething();
	}

	
	
}
