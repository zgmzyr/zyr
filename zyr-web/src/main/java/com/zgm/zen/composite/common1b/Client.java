package com.zgm.zen.composite.common1b;

/**
 * 安全模式：不支持依赖倒转原则 
 * @author Administrator
 *
 */

public class Client {

	public static void main(String[] args){
		Composite root = new Composite(); //不支持依赖倒转原则 
		root.doSomething();
		
		Composite branch = new Composite(); //不支持依赖倒转原则 
		Leaf leaf = new Leaf(); //不支持依赖倒转原则 
		
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
	}
}
