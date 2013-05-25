package com.zgm.zen.builder.example2;

import java.util.ArrayList;

public class ClientForBMW {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {

//		BenzModel benz = new BenzModel();
		CarModel benz = new BenzModel();	
		
		ArrayList<String> sequence = new ArrayList<String>();
		sequence.add("engine Boom");
		sequence.add("start");
		sequence.add("stop");
		
		benz.setSequence(sequence);
		
		benz.run();
	}*/
	
	public static void main(String[] args) {
		
		ArrayList<String> sequence = new ArrayList<String>();
		sequence.add("engine Boom");
		sequence.add("start");
		sequence.add("stop");
		
		CarBuilder bmwBuilder = new BMWBuilder();
		bmwBuilder.setSequence(sequence);
		CarModel bmw = bmwBuilder.getCarModel();
		
		bmw.run();
	}

}
