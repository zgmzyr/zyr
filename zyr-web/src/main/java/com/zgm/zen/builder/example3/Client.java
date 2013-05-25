package com.zgm.zen.builder.example3;

public class Client {

	public static void main(String[] args){
		
		Director director = new Director();
		
		for(int i = 0; i < 5; i++){
			director.getABenzModel().run();
			
		}
		
		
		for(int i = 0; i < 5; i++){
			director.getBBenzModel().run();
			
		}
		
		for(int i = 0; i < 5; i++){
			director.getABMWModel().run();
			
		}
		
		for(int i = 0; i < 5; i++){
			director.getBBMWModel().run();
			
		}
	}
}
