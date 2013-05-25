package com.zgm.zen.builder.example;

import java.util.ArrayList;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		BenzModel benz = new BenzModel();
		CarModel benz = new BenzModel();	
		
		ArrayList<String> sequence = new ArrayList<String>();
		sequence.add("engine Boom");
		sequence.add("start");
		sequence.add("stop");
		
		benz.setSequence(sequence);
		
		benz.run();
	}

}
