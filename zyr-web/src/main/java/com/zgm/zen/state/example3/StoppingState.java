package com.zgm.zen.state.example3;

public class StoppingState extends LiftState {

	@Override
	public void close() {
		
		//不做任何事
	}

	@Override
	public void open() {
		super.context.setLiftState(Context.openningState);
		super.context.getLiftState().open();
	}

	@Override
	public void run() {
		super.context.setLiftState(Context.runningState);
		super.context.getLiftState().run();
	}

	@Override
	public void stop() {
		System.out.println("电梯停止了。。。。");
	}

}
