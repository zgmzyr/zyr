package com.zgm.zen.factoryMethod.manyFactory;

public class BlackHumanFactory extends AbstractHumanFactory{

	/*public <T extends Human> T createHuman(Class<T> clazz){
		T human = null;
		
		try {
			human = (T) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return human;
		
		
		Human human = null;
		try{
			
			human = (Human) Class.forName(clazz.getName()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
		return (T) human;
	}*/
	
	public Human createHuman(){
		
		return new BlackHuman();
	}
}
