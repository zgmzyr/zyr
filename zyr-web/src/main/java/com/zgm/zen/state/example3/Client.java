package com.zgm.zen.state.example3;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Context context = new Context();
		
		context.setLiftState(new CloseingState());
		
		context.open();
		context.close();
		context.run();
		context.stop();
	}

}
