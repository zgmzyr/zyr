package com.zgm.zen.factoryMethod.singletonFactory;

import java.lang.reflect.Constructor;

public class SingletonFactory {

	private static Singleton singleton;
	
	/*static{
		try{
			
			Class clazz = Class.forName(Singleton.class.getName());
			Constructor constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			singleton = (Singleton) constructor.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
	static{
		try{
			
			singleton = (Singleton) Class.forName(Singleton.class.getName()).newInstance();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Singleton getSingleton(){
		return singleton;
	}
}
