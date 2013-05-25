package com.zgm.zen.factoryMethod.common;

/**
 * 具体工厂类
 * @author Administrator
 *
 */
public class ConcreteCreator extends Creator{

	public <T extends Product> T createProduct(Class<T> clazz){
		Product product = null;
		
		try{
			
			product = (Product) Class.forName(clazz.getName()).newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return (T) product;
	}
}
