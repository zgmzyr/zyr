package com.zgm.zen.facade.common3;

/**
 * 门面对象
 * 注：门面模式最大的缺点是：不符合开闭原则
 * @author Administrator
 *
 */
public class Facade {

	
	//被委托的对象
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
//	private ClassC c = new ClassC();
	
	private Context context = new Context();
	
	//提供给外部访问的方法
	public void methodA(){
		a.doSomethingA();
	}
	
	public void methodB(){
		b.doSomethingB();
	}
	
	 //不能这样写，因为门面对象不应该参与具体的业务逻辑，否则就会产生一个倒依赖的问题：子系统
	//必须领带门面才能被访问，这是设计上一个严重的错误，不仅违反了单一职责原则，同时也破坏了系统
	//的封装性
	/*public void methodC(){
		this.a.doSomethingA();
		c.doSomethingC();
	}*/
	
	//而应该如下 
	public void methodC(){
		this.context.complexMethod();
	}
}
