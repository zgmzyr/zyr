package com.zgm.zen.factoryMethod.manyFactory;

public class YellowHumanFactory extends AbstractHumanFactory{

	/*public <T extends Human> T createHuman(Class<T> clazz){
		
		Human human = null;
		try{
			
			human = (Human) Class.forName(clazz.getName()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
		return (T) human;
	}*/
	
	public Human createHuman(){
		return new YellowHuman();
	}
}
