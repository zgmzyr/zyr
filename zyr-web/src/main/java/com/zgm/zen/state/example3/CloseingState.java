package com.zgm.zen.state.example3;

public class CloseingState extends LiftState {

	@Override
	public void close() {
		System.out.println("电梯门关闭！");
		
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
		super.context.setLiftState(Context.stoppingState);
		super.context.getLiftState().stop();
	}

}
