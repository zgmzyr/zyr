package com.zgm.zen.integration.establishPattern_thirty.abstractFactoryVSbuilder.abstractFactory;

public class Client {

	
	public static void main(String[] args){
		
		System.out.println("=========要求生产一辆SUV==========");
		
		CarFactory carFactory = new BenzFactory();
		
		ICar benzSuv = carFactory.createSuv();
		
		System.out.println("汽车品牌： " + benzSuv.getBrand());
		
		System.out.println("汽车型号： " + benzSuv.getModel());
	}
}
