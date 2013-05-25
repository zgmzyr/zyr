package com.zgm.zen.builder.example2;

import java.util.ArrayList;

public class ClientForBenz {

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
		
		BenzBuilder benzBuilder = new BenzBuilder();
		benzBuilder.setSequence(sequence);
		CarModel benz = benzBuilder.getCarModel();
		
		benz.run();
	}

}
