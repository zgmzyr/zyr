package com.zgm.zen.state.example3;

public class RunningState extends LiftState {

	@Override
	public void close() {
		//不做任何事
		
	}

	@Override
	public void open() {
		//不做任何事
	}

	@Override
	public void run() {
		System.out.println("电梯上下运行！");
	}

	@Override
	public void stop() {
		super.context.setLiftState(Context.stoppingState);
		super.context.getLiftState().stop();
	}

}
