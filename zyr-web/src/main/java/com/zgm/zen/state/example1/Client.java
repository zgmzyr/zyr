package com.zgm.zen.state.example1;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ILift lift = new Lift();
		
		lift.open();
		lift.close();
		lift.run();
		lift.stop();
	}

}
