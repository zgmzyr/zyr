package com.zgm.zen.visitor.common;

import java.util.Random;

/**
 * 结构对象
 * @author Administrator
 *
 */
public class ObjectStruture {

	//对象生成器
	public static Element createElement(){
		Random rand = new Random();
		
		if(rand.nextInt(100) > 50){
			
			return new ConcreteElement1();
		}else{
			return new ConcreteElement2();
		}
	}
}
