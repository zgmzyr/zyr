package com.zgm.zen.state.example3;

public class OpenningState extends LiftState {

	@Override
	public void close() {

		super.context.setLiftState(Context.closeingState);
		super.context.getLiftState().close();
		
	}

	@Override
	public void open() {
		System.out.println("电梯门打开！");
	}

	@Override
	public void run() {
		//不做任何事
	}

	@Override
	public void stop() {
		//不做任何事
	}

}
