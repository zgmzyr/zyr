package com.zgm.zen.mediator.common;

/***
 * 通用抽象中介者
 * 注：
 * 		为什么同事类要使用构造函数注入中介者，而中介者使用getter/setter方法注入同事类呢？
 * 		这是因为同事类中必须要有中介者，而中介者却可以只有部分同事类。
 * @author Administrator
 *
 */
public abstract class Mediator {

	//定义同事类
	protected ConcreteColleague1 concreteColleague1;
	protected ConcreteColleague2 concreteColleague2;
	
	public ConcreteColleague1 getConcreteColleague1() {
		return concreteColleague1;
	}
	public void setConcreteColleague1(ConcreteColleague1 concreteColleague1) {
		this.concreteColleague1 = concreteColleague1;
	}
	public ConcreteColleague2 getConcreteColleague2() {
		return concreteColleague2;
	}
	public void setConcreteColleague2(ConcreteColleague2 concreteColleague2) {
		this.concreteColleague2 = concreteColleague2;
	}
	
	//中介者模式的业务逻辑
	public abstract void doSomething1();
	public abstract void doSomething2();
}
