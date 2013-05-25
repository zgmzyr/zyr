package com.zgm.zen.state.example2;

public class Client {

	public static void main(String[] args) {

		ILift lift = new Lift();
		
		lift.setState(ILift.STOPING_STATE);
		
		lift.open();
		lift.close();
		lift.run();
		lift.stop();
	}
	
	/**
	 * @param args
	 *
	public static void main(String[] args) {

		ILift lift = new Lift();
		
		lift.open();
		lift.close();
		lift.run();
		lift.stop();
	}
	*/

}
