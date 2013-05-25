package com.zgm.zen.factoryMethod.simpleFactory;

/**
 * 简单工厂模式
 * @author Administrator
 *
 */
//public class HumanFactory extends AbstractHumanFactory{
public class HumanFactory {
	/*
	public <T extends Human> T createHuman(Class<T> clazz){

		
		
		Human human = null;
		try{
			
			human = (Human) Class.forName(clazz.getName()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
		return (T) human;
	}
	*/
	
	public static <T extends Human> T createHuman(Class<T> clazz){
		Human human = null;
		try{
			
			human = (Human) Class.forName(clazz.getName()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (T) human;
	}
}
