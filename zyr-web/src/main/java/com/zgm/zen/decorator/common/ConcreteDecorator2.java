package com.zgm.zen.decorator.common;

/**
 * 具体的修饰类
 * @author Administrator
 *
 */
public class ConcreteDecorator2 extends Decorator {

	//定义被修饰者
	public ConcreteDecorator2(Component component){
		super(component);
	}
	
	//定义自己的修饰方法
	private void method2(){
		System.out.println("method2 修饰！");
	}
	
	//重写父类的operate方法
	@Override
	public void operate() {
		
		super.operate();
		this.method2();
	}

}
