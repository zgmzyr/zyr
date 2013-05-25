package com.zgm.zen.composite.common2;

/**
 * 透明模式：把用来组合使用的方法放到抽象类中。比如add(),remove()方法等
 * 好处：基本遵循了依赖倒转原则，方便系统进行扩充
 * @author Administrator
 *
 */

public class Client {

	public static void main(String[] args){
		Component root = new Composite();
		root.doSomething();
		
		Component branch = new Composite();
		Component leaf = new Leaf();
		
		root.add(branch);
		branch.add(leaf);
		
		display(root);
	}
	
	public static void display(Component root){
		for(Component c : root.getChildren()){
			if(c instanceof Leaf){
				c.doSomething();
			}else{
				display(c);  //不用进行强制转换
			}
				
		}
	}
	/*public static void main(String[] args){
		Composite root = new Composite();
		root.doSomething();
		
		Composite branch = new Composite();
		Leaf leaf = new Leaf();
		
		root.add(branch);
		branch.add(leaf);
		
		display(root);
	}
	
	public static void display(Composite root){
		for(Component c : root.getChildren()){
			if(c instanceof Leaf){
				c.doSomething();
			}else{
				display((Composite) c);
			}
		}
	}*/
}
